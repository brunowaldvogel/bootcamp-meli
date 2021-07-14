package com.bootcampmeli.apiclientes.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private long orderId;
    private static long universalId = 1L;
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalPrice = new BigDecimal(0);;
    

    public Order() {}

    public Order(
            List<Product> products, 
            BigDecimal totalPrice) {
        this.orderId = universalId++;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public long getOrderId() {
        return orderId;
    }

    public static void setUniversalId(long _universalId) {
        Order.universalId = _universalId;
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
