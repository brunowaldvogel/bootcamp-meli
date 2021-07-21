package com.bootcampmeli.apicontrolepedidos.controllers;

import java.util.List;

import com.bootcampmeli.apicontrolepedidos.dtos.OrderDTO;
import com.bootcampmeli.apicontrolepedidos.dtos.UpsertOrderDTO;
import com.bootcampmeli.apicontrolepedidos.interfaces.IOrderService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("orders")
public class OrderController {
    
    private final IOrderService orderService;
    

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("{orderId}")
    public OrderDTO getOrderById(@PathVariable long orderId) throws ResponseStatusException {
        OrderDTO orderDto = null;
        try {
            orderDto = this.orderService.getOrderById(orderId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return orderDto;
    }

    @PutMapping("{orderId}")
    public OrderDTO updateOrderById(
            @PathVariable long orderId,
            @RequestBody UpsertOrderDTO upsertOrderDTO) throws ResponseStatusException {
        OrderDTO orderDto = null;
        try {
            orderDto = this.orderService.updateOrderById(orderId, upsertOrderDTO);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return orderDto;
    }

    @DeleteMapping("{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable long orderId) throws ResponseStatusException {
        try {
            this.orderService.deleteOrderById(orderId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
