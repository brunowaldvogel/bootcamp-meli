package com.bootcampmeli.apicontrolepedidos.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcampmeli.apicontrolepedidos.entities.Order;

public class OrderDTO {
    
    private long orderId;
    private LocalDate date;
    private List<DishDTO> dishes;

    public OrderDTO() {}
    
    public OrderDTO(long orderId, LocalDate date, List<DishDTO> dishes) {
        this.orderId = orderId;
        this.date = date;
        this.dishes = dishes;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public List<DishDTO> getDishes() {
        return dishes;
    }

    public static OrderDTO toDTO(Order order) {
        List<DishDTO> dishesDTO = 
            order.getDishes().stream().map(DishDTO::toDTO).collect(Collectors.toList());
            
        return new OrderDTO(
            order.getOrderId(),
            order.getDate(),
            dishesDTO
        );
    }
}
