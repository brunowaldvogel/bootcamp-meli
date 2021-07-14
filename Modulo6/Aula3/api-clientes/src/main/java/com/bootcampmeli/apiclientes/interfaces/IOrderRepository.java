package com.bootcampmeli.apiclientes.interfaces;

import java.util.List;

import com.bootcampmeli.apiclientes.entities.Customer;
import com.bootcampmeli.apiclientes.entities.Order;

import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository {

	List<Order> getAllOrders();
    Order getOrderById(long orderId);
    void insertOrder(Customer customer, Order order);
    void deleteOrder(long orderId);
}
