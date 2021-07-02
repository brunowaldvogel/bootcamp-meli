package com.bootcampmeli.apiclientes.interfaces;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;

public interface ICustomerService {

    CustomerDTO getCustomerById(long idCustomer);
    List<CustomerDTO> getCustomers();
    
}
