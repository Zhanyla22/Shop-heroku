package com.zhanko.learningSpring.repository;

import com.zhanko.learningSpring.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
}
