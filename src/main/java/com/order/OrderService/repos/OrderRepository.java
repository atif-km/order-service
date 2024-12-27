package com.order.OrderService.repos;

import com.order.OrderService.bean.Order;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
