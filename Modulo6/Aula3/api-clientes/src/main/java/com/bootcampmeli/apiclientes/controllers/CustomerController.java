package com.bootcampmeli.apiclientes.controllers;

import java.util.List;

import javax.validation.Valid;

import com.bootcampmeli.apiclientes.dtos.CustomerDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertCustomerDTO;
import com.bootcampmeli.apiclientes.interfaces.ICustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{customerId}")
    public CustomerDTO getCustomerById(@PathVariable long customerId) {
        try {
            return this.customerService.getCustomerById(customerId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO insertCustomer(@RequestBody @Valid UpsertCustomerDTO upsertCustomerDto) {
        return this.customerService.insertCustomer(upsertCustomerDto);
    }

    @PutMapping("{customerId}")
    public CustomerDTO updateCustomer(
            @PathVariable Long customerId,
            @RequestBody @Valid UpsertCustomerDTO upsertCustomerDto) {
        try {
            return this.customerService.updateCustomer(customerId, upsertCustomerDto);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long customerId) {
        try {
            this.customerService.deleteCustomer(customerId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
