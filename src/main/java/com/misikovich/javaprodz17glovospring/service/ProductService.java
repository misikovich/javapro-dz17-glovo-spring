package com.misikovich.javaprodz17glovospring.service;

import com.misikovich.javaprodz17glovospring.converter.ProductConverter;
import com.misikovich.javaprodz17glovospring.entity.ProductEntity;
import com.misikovich.javaprodz17glovospring.model.ProductModel;
import com.misikovich.javaprodz17glovospring.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAll() {
        ArrayList<ProductEntity> productEntities = new ArrayList<>();
        productRepository.findAll().forEach(productEntities::add);
        return productEntities.stream().map(ProductConverter::entityToModel).toList();
    }
    public ProductModel get(Long id) {
        return ProductConverter.entityToModel(productRepository.findById(id).orElseThrow());
    }

    public List<ProductModel> getAllByIds(List<Long> ids) {
        return productRepository.findProductEntitiesByIdIn(ids)
                .stream()
                .map(ProductConverter::entityToModel)
                .toList();
    }

    public ProductModel add(ProductModel product) {
        return ProductConverter.entityToModel(productRepository.save(ProductConverter.modelToEntity(product)));
    }

    public ProductModel update(ProductModel product) {
        return ProductConverter.entityToModel(productRepository.save(ProductConverter.modelToEntity(product)));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
