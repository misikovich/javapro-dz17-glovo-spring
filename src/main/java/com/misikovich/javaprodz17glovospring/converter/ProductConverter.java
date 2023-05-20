package com.misikovich.javaprodz17glovospring.converter;

import com.misikovich.javaprodz17glovospring.entity.ProductEntity;
import com.misikovich.javaprodz17glovospring.model.ProductModel;

public class ProductConverter {
    public static ProductEntity modelToEntity(ProductModel model) {
        return ProductEntity
                .builder()
                .id(model.getId())
                .cost(model.getCost())
                .name(model.getName())
                .build();
    }

    public static ProductModel entityToModel(ProductEntity entity) {
        return ProductModel
                .builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .name(entity.getName())
                .build();
    }
}
