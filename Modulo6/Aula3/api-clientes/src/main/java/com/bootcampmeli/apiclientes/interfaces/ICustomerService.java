package com.bootcampmeli.apiclientes.interfaces;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertCustomerDTO;
import com.bootcampmeli.apiclientes.entities.Customer;

import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    List<CustomerDTO> getCustomers();
    Customer findCustomerById(long customerId);
    CustomerDTO getCustomerById(long customerId);
    CustomerDTO insertCustomer(UpsertCustomerDTO upsertCustomerDto);
    CustomerDTO updateCustomer(Long customerId, UpsertCustomerDTO upsertCustomerDto);
    void deleteCustomer(Long customerId);
}
