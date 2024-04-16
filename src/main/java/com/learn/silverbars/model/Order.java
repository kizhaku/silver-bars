package com.learn.silverbars.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SILVERBAR_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    Long orderId;

    @Column(name = "USER_ID")
    String userId;

    @Column(name = "QUANTITY")
    Double quantity;

    @Column(name = "PRICE")
    Double price;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    OrderType type;
}
