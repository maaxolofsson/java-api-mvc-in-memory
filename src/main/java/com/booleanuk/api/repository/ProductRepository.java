package com.booleanuk.api.repository;

import com.booleanuk.api.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<Product>();
    }

    public ArrayList<Product> getAll() {
        return this.products;
    }

    public Product getOne(int id) {
        Product toReturn = null;
        for (Product p : this.products) if (p.getId() == id) toReturn = p;
        return toReturn;
    }

    

}
