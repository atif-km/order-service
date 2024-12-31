package com.order.OrderService.service;

import com.order.OrderService.bean.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallback implements ProductServiceClient {

    @Override
    public ProductDTO getProductById(Integer id) {
        return new ProductDTO(id, "Default Product", 0.0);
    }
}