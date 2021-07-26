package com.bootcampmeli.apicontrolepedidos.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bootcampmeli.apicontrolepedidos.entities.Dish;
import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.stereotype.Repository;

@Repository
public class TableRepository implements ITableRepository {
    
    private List<Table> tables;
    private static final String jsonPath = "src/main/resources/static/tables.json";

    public TableRepository() throws RuntimeException{
        readJson();
    }

    @Override
    public void readJson() throws RuntimeException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            File tablesJson = new File(jsonPath);
            FileInputStream fileInputStream = new FileInputStream(tablesJson);
            TypeReference<List<Table>> typeReference = new TypeReference<List<Table>>(){};
            this.tables = mapper.readValue(fileInputStream, typeReference);
            setUniversalIds();
            fileInputStream.close();
        } catch (Exception ex) {
            throw new RuntimeException("The file could not be opened.");
        }
    }

    @Override
    public void writeJson() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            File tablesJson = new File(jsonPath);
            FileWriter fileWriter = new FileWriter(tablesJson);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter out = new PrintWriter(bufferedWriter);
            mapper.writeValue(out, this.tables);
            out.close();
        } catch (Exception ex) {
            throw new RuntimeException("The file could not be opened.");
        }
    }

    @Override
    public Table getTable(long tableId) throws RuntimeException {
        Optional<Table> orders = 
            this.tables.stream().filter(table -> table.getId() == tableId).findFirst();

        if (!orders.isPresent()) {
            throw new RuntimeException("Table " + tableId + " was not found.");
        }

        return orders.get();
    }

    @Override
    public void removeOrdersFromTable(long tableId) {
        Table tableToBeCleared = getTable(tableId);
        clearOrders(tableToBeCleared);
        writeJson();
    }

    @Override
    public void removeOrdersFromTable(Table table) {
        clearOrders(table);
        writeJson();
    }

    @Override
    public List<Table> getTables() {
        readJson();
        return this.tables;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> allOrders = this.tables
            .stream()
            .flatMap(table -> table.getOrders().stream()).collect(Collectors.toList());
        
        return allOrders;
    }

    @Override
    public Table addOrder(long tableId, Order order) throws RuntimeException {
        Table table = getTable(tableId);

        for (Dish dish : order.getDishes()) {
            if (!dish.dishIsValid()) {
                throw new RuntimeException("O preço ou quantidade do prato não podem ser negativos!");
            }
        }

        table.getOrders().add(order);
        table.recalculateTotalPrice();

        writeJson();

        return table;
    }

    private void clearOrders(Table table) {
        table.getOrders().clear();
        table.setTotalPrice(new BigDecimal(0));
    }

    private void setUniversalIds() {
        Table tableWithHighestId = 
            this.tables.stream().reduce((a,b) -> a.getId() > b.getId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));
        
        List<Order> allOrders = getOrders();

        if (allOrders == null || allOrders.isEmpty()) {
            Dish.setUniversalId(1);
            Order.setUniversalId(1);
            Table.setUniversalId(tableWithHighestId.getId() + 1);
            return;
        }
        
        Order orderWithHighestId = allOrders
            .stream()
            .reduce((a,b) -> a.getOrderId() > b.getOrderId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));
    
        Dish dishWithHighestId = allOrders
            .stream()
            .flatMap(order -> order.getDishes().stream())
            .reduce((a,b) -> a.getDishId() > b.getDishId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));
        
        Dish.setUniversalId(dishWithHighestId.getDishId() + 1);
        Order.setUniversalId(orderWithHighestId.getOrderId() + 1);
        Table.setUniversalId(tableWithHighestId.getId() + 1);
    }
}
