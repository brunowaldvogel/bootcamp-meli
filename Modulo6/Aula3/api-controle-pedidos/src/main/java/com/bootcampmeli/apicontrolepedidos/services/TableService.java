package com.bootcampmeli.apicontrolepedidos.services;

import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apicontrolepedidos.dtos.DishDTO;
import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;
import com.bootcampmeli.apicontrolepedidos.entities.Dish;
import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;
import com.bootcampmeli.apicontrolepedidos.interfaces.IRegisterService;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableRepository;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableService;

import org.springframework.stereotype.Service;

@Service
public class TableService implements ITableService {

    private final ITableRepository tableRepository;
    private final IRegisterService registerService;


    public TableService(
            ITableRepository tableRepository,
            IRegisterService registerService) {
        this.tableRepository = tableRepository;
        this.registerService = registerService;
    }

    @Override
    public List<Table> getAllTables() {
        return this.tableRepository.getTables();
    }

    @Override
    public List<Order> getAllOrders() {
        return this.tableRepository.getOrders();
    }

    @Override
    public Table addOrder(long tableId, UpsertOrderDTO upsertOrderDTO) {
        List<Dish> dishes = new ArrayList<>();

        for (DishDTO dishDTO : upsertOrderDTO.getDishes()) {
            Dish dish = new Dish(
                dishDTO.getPrice(),
                dishDTO.getDescription(),
                dishDTO.getQuantity()
            );
            dishes.add(dish);
        }

        Order order = new Order(tableId, dishes);

        return this.tableRepository.addOrder(tableId, order);
    }

    @Override
    public Table getTableById(long tableId) {
        return this.tableRepository.getTable(tableId);
    }

    @Override
    public Table closeOrders(long tableId) {
        Table table = this.tableRepository.getTable(tableId);
        this.registerService.addToRegister(table.getTotalPrice());

        Table closedTable = new Table(table);
        this.tableRepository.removeOrdersFromTable(table);
        
        return closedTable;
    }

    @Override
    public void readJson() {
        this.tableRepository.readJson();
    }

    @Override
    public void writeJson() {
        this.tableRepository.writeJson();
    }
}
