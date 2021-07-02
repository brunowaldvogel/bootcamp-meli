package com.bootcampmeli.apicontrolepedidos.services;

import java.util.List;

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
    public Table addOrder(long tableId, Order order) {
        order.setTableId(tableId);
        return this.tableRepository.addOrder(tableId, order);
    }

    @Override
    public Table getOrdersByTable(long tableId) {
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
}
