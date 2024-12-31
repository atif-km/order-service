package com.order.OrderService.service;

import com.order.OrderService.bean.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CustomerService", url = "http://localhost:8081", fallback = CustomerServiceFallback.class)
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable Integer id);
}
