package com.bootcampmeli.apicontrolepedidos.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Dish {
    
    private long dishId;
    @JsonIgnore
    private static long universalId = 1L;
    private BigDecimal price;
    private String description;
    private int quantity;

    
    public Dish() {}

    public Dish(BigDecimal price, String description, int quantity) {
        this.dishId = universalId++;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public boolean dishIsValid() {
        if (this.price.doubleValue() < 0 || this.quantity < 0)
            return false;
        return true;
    }

    public long getDishId() {
        return dishId;
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

    public static void setUniversalId(long _universalId) {
        Dish.universalId = _universalId;
    }
}
