package com.bootcampmeli.apicontrolepedidos.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {
    
    private long orderId;
    @JsonIgnore
    private static long universalId = 1L;
    private long tableId;
    private LocalDate date;
    private List<Dish> dishes;

    
    public Order() {}
    
    public Order(long tableId, List<Dish> dishes) {
        this.orderId = universalId++;
        this.tableId = tableId;
        this.date = LocalDate.now();
        this.dishes = dishes;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public long getTableId() {
        return this.tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public BigDecimal calculateOrderPrice() {
        BigDecimal orderPrice = new BigDecimal(0);
        
        for (Dish dish : dishes) {
            BigDecimal totalDishPrice = dish.getPrice().multiply(BigDecimal.valueOf(dish.getQuantity()));
            orderPrice = orderPrice.add(totalDishPrice);
        }

        return orderPrice;
    }

    public static void setUniversalId(long _universalId) {
        Order.universalId = _universalId;
    }
}
