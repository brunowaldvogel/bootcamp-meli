package com.bootcampmeli.apicontrolepedidos.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Table {

    private long id;
    @JsonIgnore
    private static long universalId = 1L;
    private List<Order> orders = new ArrayList<>();
    private BigDecimal totalPrice = new BigDecimal(0);


    public Table() {}

    public Table(List<Order> orders, BigDecimal totalPrice) {
        this.id = universalId++;
        this.orders = orders;
        this.totalPrice = totalPrice;
    }

    public Table(Table table) {
        this.id = table.id;
        this.orders = new ArrayList<>(table.orders);
        this.totalPrice = table.totalPrice;
    }

    public long getId() {
        return this.id;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void recalculateTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Order order : this.orders) {
            BigDecimal orderPrice = order.calculateOrderPrice();
            totalPrice = totalPrice.add(orderPrice);
        }

        this.setTotalPrice(totalPrice);
    }

    public static void setUniversalId(long _universalId) {
        Table.universalId = _universalId;
    }
}
