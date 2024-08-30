package com.booleanuk.api.controller;

import com.booleanuk.api.model.Product;
import com.booleanuk.api.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController() {
        this.productRepository = new ProductRepository();
    }

    @PostMapping
    public Product create(@RequestBody Product newProduct) {
        return this.productRepository.add(newProduct);
    }

    @GetMapping
    public ArrayList<Product> getAll() {
        return this.productRepository.getAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable int id) {
        return this.productRepository.getOne(id);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product newProductData) {
        return this.productRepository.update(id, newProductData);
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable int id) {
        return this.productRepository.remove(id);
    }

}
