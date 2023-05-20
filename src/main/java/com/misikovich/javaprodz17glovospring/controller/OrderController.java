package com.misikovich.javaprodz17glovospring.controller;

import com.misikovich.javaprodz17glovospring.model.OrderModel;
import com.misikovich.javaprodz17glovospring.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderModel> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderModel get(@PathVariable Long id) {
        return orderService.get(id);
    }
    @PutMapping
    public OrderModel update(@RequestBody OrderModel orderModel) {
        return orderService.update(orderModel);
    }
    @PostMapping
    public OrderModel add(@RequestBody OrderModel orderModel) {
        return orderService.add(orderModel);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
