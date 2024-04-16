package com.learn.silverbars.model;

import lombok.Getter;

@Getter
public class Orderboard {
    private Double price;
    private Double quantity;

    public Orderboard(Double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}
