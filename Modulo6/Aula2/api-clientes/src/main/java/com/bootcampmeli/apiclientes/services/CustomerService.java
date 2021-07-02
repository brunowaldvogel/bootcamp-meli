package com.bootcampmeli.apiclientes.services;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;
import com.bootcampmeli.apiclientes.entities.Customer;
import com.bootcampmeli.apiclientes.interfaces.ICustomerRepository;
import com.bootcampmeli.apiclientes.interfaces.ICustomerService;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO getCustomerById(long idCustomer) {
        Customer customer = this.customerRepository.getCustomerById(idCustomer);
        CustomerDTO customerDto = CustomerDTO.convertToDto(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = this.customerRepository.getCustomers();
        List<CustomerDTO> customersDTO = CustomerDTO.convertToDto(customers);
        return customersDTO;
    }
    
}
