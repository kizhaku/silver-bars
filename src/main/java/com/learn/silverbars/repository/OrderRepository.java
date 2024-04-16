package com.learn.silverbars.repository;

import com.learn.silverbars.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
