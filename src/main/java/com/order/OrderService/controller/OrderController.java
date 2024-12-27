package com.order.OrderService.controller;

import com.order.OrderService.bean.CustomerDTO;
import com.order.OrderService.bean.Order;
import com.order.OrderService.bean.ProductDTO;
import com.order.OrderService.repos.OrderRepository;
import com.order.OrderService.service.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
//@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final OrderServiceFeign orderService;

    public OrderController(OrderRepository orderRepository, OrderServiceFeign orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/customer/{customerId}")
    public CustomerDTO getCustomer(@PathVariable Integer customerId) {
        return orderService.fetchCustomer(customerId);
    }

    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable Integer productId) {
        return orderService.fetchProduct(productId);
    }
}
