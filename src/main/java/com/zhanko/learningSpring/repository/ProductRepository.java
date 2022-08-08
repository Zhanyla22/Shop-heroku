package com.zhanko.learningSpring.repository;

import com.zhanko.learningSpring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
