package com.zhanko.learningSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pId;
    @Column(name = "name")
    private String name;
    @Column(name="brand_name")
    private String brandName;
    @Column(name="cost")
    private Integer cost;
}
