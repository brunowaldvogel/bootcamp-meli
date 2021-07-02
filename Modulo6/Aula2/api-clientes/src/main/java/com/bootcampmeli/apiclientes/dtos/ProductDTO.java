package com.bootcampmeli.apiclientes.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apiclientes.entities.Product;

public class ProductDTO {
    
    private String description;
    private String color;
    private int quantity;
    private BigDecimal price;


    public ProductDTO() {}

    public ProductDTO(
            String description, 
            String color, 
            int quantity, 
            BigDecimal price) {
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public static ProductDTO convertToDto(Product product) {
        return new ProductDTO(
            product.getDescription(),
            product.getColor(),
            product.getQuantity(),
            product.getPrice()
        );
    }

    public static List<ProductDTO> convertToDto(List<Product> products) {
        List<ProductDTO> productDtos = new ArrayList<>();

        for (Product product : products) {
            productDtos.add(convertToDto(product));
        }

        return productDtos;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColor() {
        return this.color;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "{" +
            " description='" + getDescription() + "'" +
            ", color='" + getColor() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
