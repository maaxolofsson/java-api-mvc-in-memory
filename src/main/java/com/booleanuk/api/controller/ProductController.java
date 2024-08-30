package com.booleanuk.api.controller;

import com.booleanuk.api.model.Product;
import com.booleanuk.api.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED) // 201 code
    public Product create(@RequestBody Product newProduct) {
        return this.productRepository.add(newProduct);
    }

    @GetMapping
    public ArrayList<Product> getAll(@RequestBody(required = false) Product productWithCategory) {
        String givenCategory = "";
        if (productWithCategory != null) givenCategory = productWithCategory.getCategory();
        return this.productRepository.getAll(givenCategory);
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable int id) {
        return this.productRepository.getOne(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED) // 201 code
    public Product updateProduct(@PathVariable int id, @RequestBody Product newProductData) {
        return this.productRepository.update(id, newProductData);
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable int id) {
        return this.productRepository.remove(id);
    }

}
