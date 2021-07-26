package com.bootcampmeli.apicontrolepedidos.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.bootcampmeli.apicontrolepedidos.dtos.OrderDTO;
import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;

import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    
    public List<OrderDTO> getAllOrders(LocalDate date);
    public void deleteOrderById(long orderId);
    public OrderDTO getOrderById(long orderId);
    public OrderDTO updateOrderById(long orderId, UpsertOrderDTO upsertOrderDTO);
}
