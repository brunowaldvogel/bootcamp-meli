package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.util.List;

import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;

public interface ITableService {
    
    public List<Table> getAllTables();
    public Table addOrder(long tableId, Order order);
    public Table closeOrders(long tableId);
    public Table getOrdersByTable(long tableId);
}
