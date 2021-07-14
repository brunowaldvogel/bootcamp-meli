package com.bootcampmeli.apiclientes.repositories;

import java.util.List;

import com.bootcampmeli.apiclientes.entities.Customer;
import com.bootcampmeli.apiclientes.entities.Order;
import com.bootcampmeli.apiclientes.interfaces.ICustomerRepository;
import com.bootcampmeli.apiclientes.interfaces.IOrderRepository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements IOrderRepository {

    private ICustomerRepository customerRepository;

    public OrderRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return this.customerRepository.getAllOrders();
    }

    @Override
    public Order getOrderById(long orderId) throws RuntimeException {
        return this.customerRepository.getOrderById(orderId);
    }

    @Override
    public void insertOrder(Customer customer, Order order) throws RuntimeException {
        this.customerRepository.insertOrder(customer, order);
    }

    @Override
    public void deleteOrder(long orderId) {
        this.customerRepository.deleteOrder(orderId);
    }
}
