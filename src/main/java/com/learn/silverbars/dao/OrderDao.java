package com.learn.silverbars.dao;

import com.learn.silverbars.model.Order;

import java.util.List;

public interface OrderDao {
    Long registerOrder(Order order);
    void cancelOrder(Long orderId);
    List<Order> getAllOrders();
}
