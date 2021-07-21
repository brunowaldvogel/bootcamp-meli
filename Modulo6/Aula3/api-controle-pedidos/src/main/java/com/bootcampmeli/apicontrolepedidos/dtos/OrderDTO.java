package com.bootcampmeli.apicontrolepedidos.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.bootcampmeli.apicontrolepedidos.entities.Order;

public class OrderDTO {
    
    private long orderId;
    private List<DishDTO> dishes;

    public OrderDTO() {}
    
    public OrderDTO(long orderId, List<DishDTO> dishes) {
        this.orderId = orderId;
        this.dishes = dishes;
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
            dishesDTO
        );
    }
}
