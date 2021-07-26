package com.bootcampmeli.apiclientes.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.bootcampmeli.apiclientes.dtos.OrderDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertOrderDTO;
import com.bootcampmeli.apiclientes.entities.Order;

import org.springframework.stereotype.Service;

@Service
public interface IOrderService {

    List<OrderDTO> getOrders(LocalDate date);
    Order findOrderById(long orderId);
    OrderDTO getOrderById(long orderId);
    OrderDTO insertOrder(Long customerId, UpsertOrderDTO upsertOrderDTO);
    void deleteOrder(Long orderId);
    OrderDTO updateOrder(Long orderId, UpsertOrderDTO upsertOrderDTO);
}
