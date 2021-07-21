package com.bootcampmeli.apicontrolepedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcampmeli.apicontrolepedidos.dtos.DishDTO;
import com.bootcampmeli.apicontrolepedidos.dtos.OrderDTO;
import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;
import com.bootcampmeli.apicontrolepedidos.entities.Dish;
import com.bootcampmeli.apicontrolepedidos.entities.Order;
import com.bootcampmeli.apicontrolepedidos.entities.Table;
import com.bootcampmeli.apicontrolepedidos.interfaces.IOrderService;
import com.bootcampmeli.apicontrolepedidos.interfaces.ITableService;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    
    private final ITableService tableService;


    public OrderService(ITableService tableService) {
        this.tableService = tableService;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> allOrders = this.tableService.getAllOrders();
        return allOrders.stream().map(OrderDTO::toDTO).collect(Collectors.toList());
    }

    public Order findOrderById(long orderId) throws RuntimeException {
        List<Order> allOrders = this.tableService.getAllOrders();
        
        Order order = allOrders
            .stream()
            .filter(_order -> _order.getOrderId() == orderId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Could not find order with ID " + orderId));

        return order;
    }

    @Override
    public OrderDTO getOrderById(long orderId) throws RuntimeException {
        Order order = findOrderById(orderId);

        return OrderDTO.toDTO(order);
    }

    @Override
    public OrderDTO updateOrderById(
            long orderId, 
            UpsertOrderDTO upsertOrderDTO) throws RuntimeException {
        Order order = findOrderById(orderId);

        List<Dish> dishes = new ArrayList<>();
        for (DishDTO dishDTO : upsertOrderDTO.getDishes()) {
            Dish dish = new Dish(
                dishDTO.getPrice(),
                dishDTO.getDescription(),
                dishDTO.getQuantity()
            );
            dishes.add(dish);
        }
        
        order.setDishes(dishes);

        Table table = this.tableService.getTableById(order.getTableId());
        table.recalculateTotalPrice();

        this.tableService.writeJson();
        
        return OrderDTO.toDTO(order);
    }

    @Override
    public void deleteOrderById(long orderId) throws RuntimeException {
        Order order = findOrderById(orderId);
        
        Table table = this.tableService.getTableById(order.getTableId());

        table.getOrders().remove(order);
        table.recalculateTotalPrice();

        this.tableService.writeJson();
    }
}
