package com.misikovich.javaprodz17glovospring.service;

import com.misikovich.javaprodz17glovospring.converter.OrderConverter;
import com.misikovich.javaprodz17glovospring.entity.OrderEntity;
import com.misikovich.javaprodz17glovospring.model.OrderModel;
import com.misikovich.javaprodz17glovospring.model.ProductModel;
import com.misikovich.javaprodz17glovospring.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderService(ProductService productService, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public List<OrderModel> getAll() {
        ArrayList<OrderEntity> orderEntities = new ArrayList<>();
        HashSet<Long> productsIds = new HashSet<>();
        HashMap<Long, ProductModel> productModels = new HashMap<>();

        Iterable<OrderEntity> orderEntityIterable = orderRepository.findAll();
        orderEntityIterable.forEach(orderEntities::add);
        orderEntityIterable.forEach(entity -> productsIds.addAll(entity.getProducts()));

        productService.getAllByIds(productsIds.stream().toList())
                .forEach(productModel -> productModels.put(productModel.getId(), productModel));

        List<OrderModel> orderModels = orderEntities
                .stream()
                .map(OrderConverter::entityToModel)
                .toList();

        for (OrderModel orderModel : orderModels) {
            List<ProductModel> products = new ArrayList<>();
            orderModel.getProducts().forEach(p -> products.add(productModels.get(p.getId())));
            orderModel.setProducts(products);

        }
        return orderModels;
    }

    public OrderModel get(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
        OrderModel orderModel = OrderConverter.entityToModel(orderEntity);
        orderModel.setProducts(productService.getAllByIds(orderEntity.getProducts()));
        return orderModel;
    }

    public OrderModel add(OrderModel order) {
        return OrderConverter.entityToModel(orderRepository.save(OrderConverter.modelToEntity(order)));
    }

    public OrderModel update(OrderModel order) {
        return OrderConverter.entityToModel(orderRepository.save(OrderConverter.modelToEntity(order)));
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
