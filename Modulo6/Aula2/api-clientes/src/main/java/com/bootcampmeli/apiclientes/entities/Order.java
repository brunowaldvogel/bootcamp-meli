package com.bootcampmeli.apiclientes.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private long id;
    private static long universalId = 1L;
    private List<Product> products;
    private BigDecimal totalPrice;
    

    public Order() {
        this.id = universalId++;
        this.products = new ArrayList<Product>();
        this.totalPrice = new BigDecimal(0);
    }

    public Order(List<Product> products, BigDecimal totalPrice) {
        this.id = universalId++;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
