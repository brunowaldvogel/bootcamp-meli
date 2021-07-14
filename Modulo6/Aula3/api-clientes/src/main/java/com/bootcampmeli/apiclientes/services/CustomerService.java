package com.bootcampmeli.apiclientes.services;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertCustomerDTO;
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
    public Customer findCustomerById(long customerId) throws RuntimeException {
        return this.customerRepository.getCustomerById(customerId);
    }

    @Override
    public CustomerDTO getCustomerById(long customerId) throws RuntimeException {
        Customer customer = this.customerRepository.getCustomerById(customerId);
        return CustomerDTO.convertToDto(customer);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = this.customerRepository.getCustomers();
        return CustomerDTO.convertToDto(customers);
    }

    @Override
    public CustomerDTO insertCustomer(UpsertCustomerDTO upsertCustomerDto) {
        Customer customer = new Customer(
            upsertCustomerDto.getCpf(),
            upsertCustomerDto.getEmail(),
            upsertCustomerDto.getCellphone()
        );

        this.customerRepository.insertCustomer(customer);
        return CustomerDTO.convertToDto(customer);
    }

    @Override
    public CustomerDTO updateCustomer(
            Long customerId, 
            UpsertCustomerDTO upsertCustomerDto) throws RuntimeException {
        Customer customer = this.customerRepository.getCustomerById(customerId);
        customer.setCellphone(upsertCustomerDto.getCellphone());
        customer.setCpf(upsertCustomerDto.getCpf());
        customer.setEmail(upsertCustomerDto.getEmail());
        
        return CustomerDTO.convertToDto(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws RuntimeException {
        Customer customer = this.customerRepository.getCustomerById(customerId);
        this.customerRepository.deleteCustomer(customer);
    }
    
}
