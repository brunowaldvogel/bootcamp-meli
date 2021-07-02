package com.bootcampmeli.apiclientes.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bootcampmeli.apiclientes.entities.*;
import com.bootcampmeli.apiclientes.interfaces.ICustomerRepository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private List<Customer> customers;


    public CustomerRepository() {
        List<Product> productsOrder1 = new ArrayList<>();
        productsOrder1.add(new Product("Bola de Futebol", "Branco", 1, new BigDecimal(15)));
        productsOrder1.add(new Product("Manequim", "Preto", 2, new BigDecimal(10)));

        List<Product> productsOrder2 = new ArrayList<>();
        productsOrder2.add(new Product("Camiseta", "Laranja", 1, new BigDecimal(30)));
        productsOrder2.add(new Product("Shorts", "Roxo", 1, new BigDecimal(10)));

        List<Product> productsOrder3 = new ArrayList<>();
        productsOrder3.add(new Product("Shorts", "Cinza", 3, new BigDecimal(15)));

        Order[] orders = {
            new Order(productsOrder1, new BigDecimal(35)),
            new Order(productsOrder2, new BigDecimal(40)),
            new Order(productsOrder3, new BigDecimal(45)),
        };

        List<Order> ordersCustomer1 = new ArrayList<>();
        ordersCustomer1.add(orders[0]);
        ordersCustomer1.add(orders[1]);

        List<Order> ordersCustomer2 = new ArrayList<>();
        ordersCustomer2.add(orders[2]);

        this.customers = new ArrayList<>();
        this.customers.add(new Customer("452.123.412-16", "email1@gmail.com", "(11) 99429-3929", ordersCustomer1));
        this.customers.add(new Customer("453.623.123-15", "customer2@hotmail.com", "(11) 9732-3282", ordersCustomer2));
    }

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public Customer getCustomerById(long idCustomer) throws RuntimeException {
        Optional<Customer> customer = 
            this.customers.stream().filter(_customer -> _customer.getId() == idCustomer).findFirst();

        if (!customer.isPresent()) {
            throw new RuntimeException("O cliente com ID " + idCustomer + " não foi encontrado.");
        }

        return customer.get();
    }

    @Override
    public List<Customer> getCustomers() {
        return this.customers;
    }
    
}
