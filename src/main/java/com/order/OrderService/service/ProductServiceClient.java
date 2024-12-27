package com.order.OrderService.service;

import com.order.OrderService.bean.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "ProductService", url = "http://localhost:8082")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable Integer id);
}
