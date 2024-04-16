package com.learn.silverbars.service;

import com.google.gson.Gson;
import com.learn.silverbars.dao.OrderDao;
import com.learn.silverbars.model.Order;
import com.learn.silverbars.model.OrderType;
import com.learn.silverbars.model.Orderboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDao dao;

    @Autowired
    Gson gson;

    @Override
    public Long registerOrder(Order order) throws Exception {
        return dao.registerOrder(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        dao.cancelOrder(orderId);
    }

    @Override
    public Map<OrderType, List<Orderboard>> getOrdersForDashboard() {
        List<Order> orders = dao.getAllOrders();

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getType))
                .entrySet()
                .stream()
                .map(entry -> Map.entry(entry.getKey(), combineOrdersByPrice(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private List<Orderboard> combineOrdersByPrice(List<Order> orders) {
        return orders
                .stream()
                .collect(Collectors.groupingBy(Order::getPrice))
                .entrySet()
                .stream()
                .map(entry ->
                        new Orderboard(
                                entry.getKey(),
                                entry.getValue()
                                        .stream()
                                        .collect(Collectors.summarizingDouble(Order::getQuantity))
                                        .getSum()
                        )
                ).toList();
    }
}
