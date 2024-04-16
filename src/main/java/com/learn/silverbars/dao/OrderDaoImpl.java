package com.learn.silverbars.dao;

import com.learn.silverbars.model.Order;
import com.learn.silverbars.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepository repository;

    @Override
    public Long registerOrder(Order order) {
        return repository.save(order).getOrderId();
    }

    @Override
    public void cancelOrder(Long orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
