package com.order.OrderService.service;

import com.order.OrderService.bean.CustomerDTO;
import com.order.OrderService.bean.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${product.service.url}")
    private String productServiceUrl;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CustomerDTO getCustomerById(Long customerId) {
        return restTemplate.getForObject(customerServiceUrl + "/customers/" + customerId, CustomerDTO.class);
    }

    public ProductDTO getProductById(Long productId) {
        return restTemplate.getForObject(productServiceUrl + "/products/" + productId, ProductDTO.class);
    }
}
