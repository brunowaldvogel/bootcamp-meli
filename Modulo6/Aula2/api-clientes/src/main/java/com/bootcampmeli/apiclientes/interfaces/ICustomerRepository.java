package com.bootcampmeli.apiclientes.interfaces;

import java.util.List;

import com.bootcampmeli.apiclientes.entities.Customer;

public interface ICustomerRepository {

    List<Customer> getCustomers();
    Customer getCustomerById(long idCustomer);
}
