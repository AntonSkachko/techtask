package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrder() {
        return orderRepository
                .findFirstByQuantityGreaterThanOrderByCreatedAtDesc(1)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findByUserStatusOrderByCreatedAtDesc();
    }
}
