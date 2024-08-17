package com.example.techtask.repository;

import com.example.techtask.model.Order;
import com.example.techtask.model.enumiration.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findFirstByQuantityGreaterThanOrderByCreatedAtDesc(
            int quantity);

    @Query(""" 
            SELECT o FROM Order o 
            JOIN User u   
            ON o.userId = u.id   
            WHERE u.userStatus = 'ACTIVE'
            ORDER BY o.createdAt DESC 
            """)
    List<Order> findByUserStatusOrderByCreatedAtDesc();
}
