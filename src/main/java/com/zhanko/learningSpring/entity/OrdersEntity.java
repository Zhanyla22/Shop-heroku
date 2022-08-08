package com.zhanko.learningSpring.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer oId;

    @ManyToOne
    private CustomerEntity customerEntity;

    @ManyToOne
    private  ProductEntity productEntity;

    @Column(name = "order_date")
    private String orderDate;  //надо соединить с рисепт орд дэйт
}
