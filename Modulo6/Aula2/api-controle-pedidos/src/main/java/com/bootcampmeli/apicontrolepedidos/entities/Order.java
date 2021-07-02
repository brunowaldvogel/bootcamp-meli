package com.bootcampmeli.apicontrolepedidos.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {
    
    @JsonIgnore
    private long id;
    @JsonIgnore
    private static long universalId = 1L;
    private long tableId;
    private List<Dish> dishes;

    
    public Order(long tableId, List<Dish> dishes) {
        this.id = universalId++;
        this.tableId = tableId;
        this.dishes = dishes;
    }

    public long getId() {
        return this.id;
    }

    public long getTableId() {
        return this.tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

}
