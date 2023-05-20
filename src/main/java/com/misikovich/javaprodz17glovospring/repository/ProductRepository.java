package com.misikovich.javaprodz17glovospring.repository;

import com.misikovich.javaprodz17glovospring.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findProductEntitiesByIdIn(List<Long> ids);
}
