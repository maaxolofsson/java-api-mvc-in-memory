package com.booleanuk.api.controller;

import com.booleanuk.api.model.Product;
import com.booleanuk.api.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Product added = this.productRepository.add(newProduct);
        if (added != null) return added;
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ArrayList<Product> getAll(@RequestBody(required = false) Product productWithCategory) {
        String givenCategory = "";
        if (productWithCategory != null) {
            givenCategory = productWithCategory.getCategory();
            ArrayList<Product> toReturn = this.productRepository.getAll(givenCategory);
            if (toReturn == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return this.productRepository.getAll(null);
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable int id) {
        Product toReturn = this.productRepository.getOne(id);
        if (toReturn != null) return toReturn;
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
