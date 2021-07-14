package com.bootcampmeli.apiclientes.controllers;

import java.util.List;

import com.bootcampmeli.apiclientes.dtos.OrderDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertOrderDTO;
import com.bootcampmeli.apiclientes.interfaces.IOrderService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("orders")
public class OrderController {
    
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return this.orderService.getOrders();
    }

    @GetMapping("{orderId}")
    public OrderDTO getOrderById(@PathVariable long orderId) {
        try {
            return this.orderService.getOrderById(orderId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("customer/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO insertOrder(
            @PathVariable Long customerId,
            @RequestBody UpsertOrderDTO upsertOrderDTO) {
        try {
            return this.orderService.insertOrder(customerId, upsertOrderDTO);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PutMapping("{orderId}")
    public OrderDTO updateOrder(
            @PathVariable Long orderId,
            @RequestBody UpsertOrderDTO upsertOrderDTO) {
        try {
            return this.orderService.updateOrder(orderId, upsertOrderDTO);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long orderId) {
        try {
            this.orderService.deleteOrder(orderId);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

}
