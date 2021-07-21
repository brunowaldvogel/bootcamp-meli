package com.bootcampmeli.apicontrolepedidos.dtos;

import java.math.BigDecimal;

import com.bootcampmeli.apicontrolepedidos.entities.Dish;

public class DishDTO {
    
    private long id;
    private BigDecimal price;
    private String description;
    private int quantity;

    public DishDTO() {}

    public DishDTO(
            long id,
            BigDecimal price, 
            String description, 
            int quantity) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
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

    public static DishDTO toDTO(Dish dish) {
        return new DishDTO(
            dish.getDishId(),
            dish.getPrice(),
            dish.getDescription(),
            dish.getQuantity()
        );
    }
}
