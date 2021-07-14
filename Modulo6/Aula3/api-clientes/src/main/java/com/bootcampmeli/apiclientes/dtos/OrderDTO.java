package com.bootcampmeli.apiclientes.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bootcampmeli.apiclientes.entities.Order;

public class OrderDTO {
    
    private Long orderId;
    private List<ProductDTO> products;
    private BigDecimal totalPrice;


    public OrderDTO() {}

    public OrderDTO(
            Long orderId,
            List<ProductDTO> products, 
            BigDecimal totalPrice) {
        this.orderId = orderId;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public static OrderDTO convertToDto(Order order) {
        return new OrderDTO(
            order.getOrderId(),
            ProductDTO.convertToDto(order.getProducts()),
            order.getTotalPrice()
        );
    }

    public static List<OrderDTO> convertToDto(List<Order> orders) {
        List<OrderDTO> orderDtos = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDto = convertToDto(order);
            orderDtos.add(orderDto);
        }

        return orderDtos;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public List<ProductDTO> getProducts() {
        return this.products;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
}
