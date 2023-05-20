package com.misikovich.javaprodz17glovospring.converter;

import com.misikovich.javaprodz17glovospring.entity.OrderEntity;
import com.misikovich.javaprodz17glovospring.model.OrderModel;
import com.misikovich.javaprodz17glovospring.model.ProductModel;

public class OrderConverter {
    public static OrderEntity modelToEntity(OrderModel model) {
        return OrderEntity.builder()
                .id(model.getId())
                .date(model.getDate())
                .cost(model.getCost())
                .products(model.getProducts()
                        .stream()
                        .map(ProductModel::getId)
                        .toList())
                .build();
    }

    public static OrderModel entityToModel(OrderEntity entity) {
        return OrderModel.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .cost(entity.getCost())
                .products(entity.getProducts()
                        .stream()
                        .map(e -> ProductModel.builder().id(e).build())
                        .toList())
                .build();
    }
}
