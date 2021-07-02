package com.bootcampmeli.apicontrolepedidos.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Dish {
    
    @JsonIgnore
    private long id;
    @JsonIgnore
    private static long universalId = 1L;
    private BigDecimal price;
    private String description;
    private int quantity;


    public Dish(BigDecimal price, String description, int quantity) {
        this.id = universalId++;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public boolean dishIsValid() {
        if (this.price.doubleValue() < 0 || this.quantity < 0)
            return false;
        return true;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
