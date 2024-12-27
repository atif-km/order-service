package com.order.OrderService.service;

import com.order.OrderService.bean.CustomerDTO;
import com.order.OrderService.bean.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceFeign {

    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;

    public OrderServiceFeign(CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient) {
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
    }

    public CustomerDTO fetchCustomer(Integer customerId) {
        return customerServiceClient.getCustomerById(customerId);
    }

    public ProductDTO fetchProduct(Integer productId) {
        return productServiceClient.getProductById(productId);
    }
}
