package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.util.List;

import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;

public interface ITableRepository {

    public List<Table> getTables();
    public List<Order> getOrders();
    public Table getTable(long tableId);
    public void removeOrdersFromTable(Table table);
    public void removeOrdersFromTable(long tableId);
    public Table addOrder(long tableId, Order order);
    public void readJson();
    public void writeJson();
}
