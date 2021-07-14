package com.bootcampmeli.apiclientes.dtos;

import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apiclientes.entities.Customer;

public class CustomerDTO {
    
    private Long id;
    private String cpf;
    private String email;
    private String cellphone;
    private List<OrderDTO> orders;


    public CustomerDTO() {}

    public CustomerDTO(
            Long id,
            String cpf, 
            String email, 
            String cellphone, 
            List<OrderDTO> orders) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.cellphone = cellphone;
        this.orders = orders;
    }

    public static CustomerDTO convertToDto(Customer customer) {
        return new CustomerDTO(
            customer.getId(),
            customer.getCpf(), 
            customer.getEmail(), 
            customer.getCellphone(), 
            OrderDTO.convertToDto(customer.getOrders()));
    }

    public static List<CustomerDTO> convertToDto(List<Customer> customers) {
        List<CustomerDTO> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            customerDtos.add(convertToDto(customer));
        }

        return customerDtos;
    }

    public Long getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public List<OrderDTO> getOrders() {
        return this.orders;
    }
}
