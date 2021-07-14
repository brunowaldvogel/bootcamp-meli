package com.bootcampmeli.apiclientes.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private long id;
    private static long universalId = 1L;
    private String cpf;
    private String email;
    private String cellphone;
    private List<Order> orders = new ArrayList<>();

    
    public Customer() {}

    public Customer(
            String cpf, 
            String email, 
            String cellphone) {
        this.id = universalId++;
        this.cpf = cpf;
        this.email = email;
        this.cellphone = cellphone;
        this.orders = new ArrayList<>();
    }

    public Customer(
            String cpf, 
            String email, 
            String cellphone, 
            List<Order> orders) {
        this.id = universalId++;
        this.cpf = cpf;
        this.email = email;
        this.cellphone = cellphone;
        this.orders = orders;
    }

    public long getId() {
        return this.id;
    }

    public static void setUniversalId(long _universalId) {
        Customer.universalId = _universalId;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
