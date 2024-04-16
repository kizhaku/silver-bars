package com.learn.silverbars.controller;

import com.learn.silverbars.model.Order;
import com.learn.silverbars.model.OrderType;
import com.learn.silverbars.model.Orderboard;
import com.learn.silverbars.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    OrderService service;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<String> registerOrder(@RequestBody Order order) throws Exception {
        Long orderId = service.registerOrder(order);

        return new ResponseEntity<>("Order registered with ID: "+orderId, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> cancelOrder(@PathVariable(required = true) Long orderId) throws Exception {
        service.cancelOrder(orderId);

        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/orderboard", method = RequestMethod.GET)
    public ResponseEntity<Map<OrderType, List<Orderboard>>> orderBoard() throws Exception {

        return new ResponseEntity<>(service.getOrdersForDashboard(), HttpStatus.OK);
    }
}
