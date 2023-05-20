package com.misikovich.javaprodz17glovospring.controller;

import com.misikovich.javaprodz17glovospring.model.ProductModel;
import com.misikovich.javaprodz17glovospring.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ProductModel get(@PathVariable Long id) {
        return productService.get(id);
    }
    @PutMapping
    public ProductModel update(@RequestBody ProductModel productModel) {
        return productService.update(productModel);
    }
    @PostMapping
    public ProductModel add(@RequestBody ProductModel productModel) {
        return productService.add(productModel);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
