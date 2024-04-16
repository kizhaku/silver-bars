package com.learn.silverbars.service;

import com.learn.silverbars.model.Order;
import com.learn.silverbars.model.OrderType;
import com.learn.silverbars.model.Orderboard;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Long registerOrder(Order order) throws Exception;
    void cancelOrder(Long orderId);
    Map<OrderType, List<Orderboard>> getOrdersForDashboard();
}
