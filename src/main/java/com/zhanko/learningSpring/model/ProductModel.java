package com.zhanko.learningSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductModel {
    private Integer pId;
    private String name;
    private String brandName;
    private Integer cost;
}
