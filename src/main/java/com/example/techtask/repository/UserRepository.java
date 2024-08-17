package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
        SELECT u FROM User u 
        JOIN u.orders o 
        WHERE o.orderStatus = 'DELIVERED' AND YEAR(o.createdAt) = 2003
        GROUP BY u.id
        ORDER BY SUM(o.price * o.quantity) DESC
        LIMIT 1
    """)
    Optional<User> findUserWithMaxTotalDeliveredIn2003();

    @Query("""
        SELECT DISTINCT u FROM User u 
        JOIN u.orders o 
        WHERE o.orderStatus = 'PAID' AND YEAR(o.createdAt) = 2010
    """)
    List<User> findUsersWithPaidOrdersIn2010();
}
