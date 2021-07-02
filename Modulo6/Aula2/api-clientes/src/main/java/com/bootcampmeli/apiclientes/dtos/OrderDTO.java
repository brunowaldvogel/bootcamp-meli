package com.bootcampmeli.apiclientes.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apiclientes.entities.Order;

public class OrderDTO {
    
    private List<ProductDTO> products;
    private BigDecimal totalPrice;


    public OrderDTO() {}

    public OrderDTO(List<ProductDTO> products, BigDecimal totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public static OrderDTO convertToDto(Order order) {
        return new OrderDTO(
            ProductDTO.convertToDto(order.getProducts()),
            order.getTotalPrice()
        );
    }

    public static List<OrderDTO> convertToDto(List<Order> orders) {
        List<OrderDTO> orderDtos = new ArrayList<>();

        for (Order order : orders) {
            orderDtos.add(convertToDto(order));
        }

        return orderDtos;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
