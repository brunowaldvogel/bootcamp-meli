package com.bootcampmeli.apiclientes.controllers;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;
import com.bootcampmeli.apiclientes.interfaces.ICustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("customers")
public class CustomerController {
    
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<CustomerDTO> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping("{idCustomer}")
    public CustomerDTO getCustomerById(@PathVariable long idCustomer) {
        CustomerDTO customerDTO = null;
        try {
            customerDTO = this.customerService.getCustomerById(idCustomer);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

        return customerDTO;
    }
}
