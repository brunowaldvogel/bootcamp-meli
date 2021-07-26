package com.bootcampmeli.apiclientes.controllers;

import java.time.LocalDate;
import java.util.List;

import com.bootcampmeli.apiclientes.dtos.OrderDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertOrderDTO;
import com.bootcampmeli.apiclientes.interfaces.IOrderService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<OrderDTO> getOrders(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.orderService.getOrders(date);
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
