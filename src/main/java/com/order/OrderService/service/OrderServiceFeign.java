package com.order.OrderService.service;

import com.order.OrderService.bean.CustomerDTO;
import com.order.OrderService.bean.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceFeign {

    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;

    public OrderServiceFeign(CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient) {
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
    }

    @CircuitBreaker(name = "customerServiceCB",fallbackMethod = "getCustomerById" )
    public CustomerDTO fetchCustomer(Integer customerId) {
        return customerServiceClient.getCustomerById(customerId);
    }
    public CustomerDTO getCustomerById(Integer customerId, Throwable throwable) {
        System.out.println("*********************************in customer fall back************************************");
        return new CustomerDTO(customerId, "Default Customer", "Customer service unavailable");

    }

    @CircuitBreaker(name = "productServiceCB",fallbackMethod = "getProductById")
    public ProductDTO fetchProduct(Integer productId) {
        return productServiceClient.getProductById(productId);
    }

    public ProductDTO getProductById(Integer productId, Throwable throwable) {
        System.out.println("*********************************in product fall back************************************");
        return new ProductDTO(productId, "Default Product", 0.0);

    }
}
