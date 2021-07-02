package com.bootcampmeli.apicontrolepedidos.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bootcampmeli.apicontrolepedidos.entities.Dish;
import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableRepository;

import org.springframework.stereotype.Repository;

@Repository
public class TableRepository implements ITableRepository {
    
    private List<Table> tables;

    public TableRepository() {
        List<Dish> listOfDishes1 = new ArrayList<>();
        listOfDishes1.add(new Dish(new BigDecimal(10), "Pastel", 1));
        listOfDishes1.add(new Dish(new BigDecimal(15), "Carne", 2));
        listOfDishes1.add(new Dish(new BigDecimal(5), "Coxinha", 3));

        List<Dish> listOfDishes2 = new ArrayList<>();
        listOfDishes2.add(new Dish(new BigDecimal(5), "Cuca de banana", 2));
        listOfDishes2.add(new Dish(new BigDecimal(20), "Peixe", 1));

        List<Dish> listOfDishes3 = new ArrayList<>();
        listOfDishes3.add(new Dish(new BigDecimal(1.5), "Pão com manteiga", 2));

        List<Order> listOfOrdersTable1 = new ArrayList<>();
        listOfOrdersTable1.add(new Order(1, listOfDishes1));
        listOfOrdersTable1.add(new Order(1, listOfDishes2));

        List<Order> listOfOrdersTable2 = new ArrayList<>();
        listOfOrdersTable2.add(new Order(2, listOfDishes3));

        this.tables = new ArrayList<>();
        this.tables.add(new Table(listOfOrdersTable1, new BigDecimal(85)));
        this.tables.add(new Table(listOfOrdersTable2, new BigDecimal(3)));
        this.tables.add(new Table());
        this.tables.add(new Table());
        this.tables.add(new Table());
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
    }

    @Override
    public void removeOrdersFromTable(Table table) {
        clearOrders(table);
    }

    @Override
    public List<Table> getTables() {
        return this.tables;
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

        BigDecimal orderPrice = new BigDecimal(0);
        for (Dish dish : order.getDishes()) {
            BigDecimal totalDishPrice = dish.getPrice().multiply(BigDecimal.valueOf(dish.getQuantity()));
            orderPrice = orderPrice.add(totalDishPrice);
        }

        table.setTotalPrice(table.getTotalPrice().add(orderPrice));
        return table;
    }

    private void clearOrders(Table table) {
        table.getOrders().clear();
        table.setTotalPrice(new BigDecimal(0));
    }
}
