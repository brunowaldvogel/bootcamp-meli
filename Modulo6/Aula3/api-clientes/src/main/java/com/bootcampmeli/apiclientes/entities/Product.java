package com.bootcampmeli.apiclientes.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apiclientes.dtos.ProductDTO;

public class Product {
    
    private long id;
    private static long universalId = 1L;
    private String description;
    private String color;
    private int quantity;
    private BigDecimal price = new BigDecimal(0);


    public Product() {}

    public Product(
            String description, 
            String color, 
            int quantity, 
            BigDecimal price) {
        this.id = universalId++;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public static void setUniversalId(long _universalId) {
        Product.universalId = _universalId;
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

    public static List<Product> convertFromDto(List<ProductDTO> productDtos) {
        List<Product> orderProducts = new ArrayList<>();
        
        for (ProductDTO productDto : productDtos) {
            Product product = new Product(
                productDto.getDescription(),
                productDto.getColor(),
                productDto.getQuantity(),
                productDto.getPrice()
            );
            orderProducts.add(product);
        }

        return orderProducts;
    }

}
