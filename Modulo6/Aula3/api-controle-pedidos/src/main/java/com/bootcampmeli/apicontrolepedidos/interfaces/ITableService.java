package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.util.List;

import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;
import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;

public interface ITableService {
    
    public void readJson();
    public void writeJson();
    public List<Table> getAllTables();
    public List<Order> getAllOrders();
    public Table closeOrders(long tableId);
    public Table getTableById(long tableId);
    public Table addOrder(long tableId, UpsertOrderDTO upsertOrderDTO);
}
