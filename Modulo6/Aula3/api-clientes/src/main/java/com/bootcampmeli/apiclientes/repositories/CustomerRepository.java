package com.bootcampmeli.apiclientes.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcampmeli.apiclientes.entities.*;
import com.bootcampmeli.apiclientes.interfaces.ICustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private List<Customer> customers;
    private static final String jsonPath = "src/main/resources/static/customers.json";

    public CustomerRepository() throws RuntimeException {
        readJson();
    }

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public void readJson() throws RuntimeException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            File customersJson = new File(jsonPath);
            FileInputStream fileInputStream = new FileInputStream(customersJson);
            TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
            this.customers = mapper.readValue(fileInputStream, typeReference);
            setUniversalIds();
            fileInputStream.close();
        } catch (Exception ex) {
            throw new RuntimeException("The file could not be opened.");
        }
    }

    public void writeJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            File customersJson = new File(jsonPath);
            FileWriter fileWriter = new FileWriter(customersJson);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter out = new PrintWriter(bufferedWriter);
            mapper.writeValue(out, this.customers);
            out.close();
        } catch (Exception ex) {
            throw new RuntimeException("The file could not be opened.");
        }
    }

    @Override
    public Customer getCustomerById(long customerId) throws RuntimeException {
        readJson();
        return this.customers.stream()
            .filter(customer -> customer.getId() == customerId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("O cliente com ID " + customerId + " não foi encontrado."));
    }

    @Override
    public List<Customer> getCustomers() {
        readJson();
        return this.customers;
    }

    @Override
    public void insertCustomer(Customer customer) {
        this.customers.add(customer);
        writeJson();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        this.customers.remove(customer);
        writeJson();
    }

    @Override
    public List<Order> getAllOrders() {
        readJson();
        List<Order> allOrders = new ArrayList<>();
        
        for (Customer customer : this.customers) {
            customer.getOrders().stream().forEach(order -> allOrders.add(order));
        }

        return allOrders;
    }

    @Override
    public Order getOrderById(long orderId) throws RuntimeException {
        readJson();
        List<Order> allOrders = getAllOrders();

        return allOrders.stream()
            .filter(_order -> _order.getOrderId() == orderId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("O pedido com ID " + orderId + " não foi encontrado."));
    }

    @Override
    public void insertOrder(Customer customer, Order order) {
        customer.getOrders().add(order);
        writeJson();
    }

    @Override
    public void deleteOrder(long orderId) throws RuntimeException {
        getOrderById(orderId);

        for (Customer customer : this.customers) {
            for (Order order: customer.getOrders()) {
                if (order.getOrderId() == orderId) {
                    customer.getOrders().remove(order);
                    writeJson();
                    return;
                }
            }
        }
    }

    private void setUniversalIds() {
        Customer customerWithHighestId = 
            this.customers.stream().reduce((a,b) -> a.getId() > b.getId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));
        
        List<Order> allOrders = this.customers
            .stream()
            .flatMap(customer -> customer.getOrders().stream()).collect(Collectors.toList());
        
        Order orderWithHighestId = allOrders
            .stream()
            .reduce((a,b) -> a.getOrderId() > b.getOrderId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));
        
        Product productWithHighestId = allOrders
            .stream()
            .flatMap(order -> order.getProducts().stream())
            .reduce((a,b) -> a.getId() > b.getId() ? a : b).orElseThrow(
                () -> new RuntimeException("Falha ao setar os ids universais do banco."));

        Customer.setUniversalId(customerWithHighestId.getId() + 1);
        Order.setUniversalId(orderWithHighestId.getOrderId() + 1);
        Product.setUniversalId(productWithHighestId.getId() + 1);
    }
}
