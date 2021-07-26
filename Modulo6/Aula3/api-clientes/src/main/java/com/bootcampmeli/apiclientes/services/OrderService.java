package com.bootcampmeli.apiclientes.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcampmeli.apiclientes.dtos.OrderDTO;
import com.bootcampmeli.apiclientes.dtos.UpsertOrderDTO;
import com.bootcampmeli.apiclientes.entities.Customer;
import com.bootcampmeli.apiclientes.entities.Order;
import com.bootcampmeli.apiclientes.entities.Product;
import com.bootcampmeli.apiclientes.interfaces.ICustomerService;
import com.bootcampmeli.apiclientes.interfaces.IOrderRepository;
import com.bootcampmeli.apiclientes.interfaces.IOrderService;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private IOrderRepository orderRepository;
    private ICustomerService customerService;


    public OrderService(
            IOrderRepository orderRepository,
            ICustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    @Override
    public List<OrderDTO> getOrders(LocalDate date) {
        List<Order> orders = this.orderRepository.getAllOrders();

        if (date != null) {
            orders = orders
                .stream()
                .filter(order -> order.getDate().equals(date))
                .collect(Collectors.toList());
        }

        return OrderDTO.convertToDto(orders);
    }

    @Override
    public Order findOrderById(long orderId) throws RuntimeException {
        return this.orderRepository.getOrderById(orderId);
    }

    @Override
    public OrderDTO getOrderById(long orderId) throws RuntimeException {
        Order order = findOrderById(orderId);
        return OrderDTO.convertToDto(order);
    }

    @Override
    public OrderDTO insertOrder(
            Long customerId, 
            UpsertOrderDTO upsertOrderDTO) throws RuntimeException {
        Customer customer = this.customerService.findCustomerById(customerId);

        List<Product> orderProducts = Product.convertFromDto(upsertOrderDTO.getProducts());
        BigDecimal orderPrice = calculateOrderTotalPrice(orderProducts);
        Order order = new Order(orderProducts, orderPrice);

        this.orderRepository.insertOrder(customer, order);
        
        return OrderDTO.convertToDto(order);
    }
    
    private BigDecimal calculateOrderTotalPrice(List<Product> orderProducts) {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Product product : orderProducts) {
            BigDecimal productTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
            totalPrice = totalPrice.add(productTotalPrice);
        }

        return totalPrice;
    }

    @Override
    public void deleteOrder(Long orderId) throws RuntimeException {
        this.orderRepository.deleteOrder(orderId);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, UpsertOrderDTO upsertOrderDTO) throws RuntimeException {
        Order order = findOrderById(orderId);
        List<Product> orderProducts = Product.convertFromDto(upsertOrderDTO.getProducts());
        BigDecimal orderPrice = calculateOrderTotalPrice(orderProducts);

        order.setProducts(orderProducts);
        order.setTotalPrice(orderPrice);

        return OrderDTO.convertToDto(order);
    }
}
