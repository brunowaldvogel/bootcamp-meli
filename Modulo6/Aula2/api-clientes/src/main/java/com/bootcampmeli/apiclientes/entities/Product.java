package com.bootcampmeli.apiclientes.entities;

import java.math.BigDecimal;

public class Product {
    
    private long id;
    private static long universalId = 1L;
    private String description;
    private String color;
    private int quantity;
    private BigDecimal price;


    public Product() {
        this.id = universalId++;
        this.description = "";
        this.color = "";
        this.quantity = 0;
        this.price = new BigDecimal(0);
    }

    public Product(String description, String color, int quantity, BigDecimal price) {
        this.id = universalId++;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", description='" + getDescription() + "'" +
            ", color='" + getColor() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
