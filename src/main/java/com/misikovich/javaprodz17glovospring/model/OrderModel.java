package com.misikovich.javaprodz17glovospring.model;

import com.misikovich.javaprodz17glovospring.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {
    private Long id;
    private Date date;
    private double cost;
    private List<ProductModel> products;
}
