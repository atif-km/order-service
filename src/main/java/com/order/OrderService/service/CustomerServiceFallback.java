package com.order.OrderService.service;

import com.order.OrderService.bean.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFallback implements CustomerServiceClient{
    @Override
    public CustomerDTO getCustomerById(Integer customerId) {
        System.out.println("*********************************in fall back************************************");
        return new CustomerDTO(customerId, "Pefault Customer", "Customer service unavailable");

    }
}
