package com.misikovich.javaprodz17glovospring.repository;

import com.misikovich.javaprodz17glovospring.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
