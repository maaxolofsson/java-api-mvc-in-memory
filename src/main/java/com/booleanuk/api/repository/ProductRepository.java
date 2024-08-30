package com.booleanuk.api.repository;

import com.booleanuk.api.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<Product>();
    }

    public Product add(Product newProduct) {
        this.products.add(newProduct);
        return newProduct;
    }

    public ArrayList<Product> getAll() {
        return this.products;
    }

    public Product getOne(int id) {
        Product toReturn = null;
        for (Product p : this.products) if (p.getId() == id) toReturn = p;
        return toReturn;
    }

    public Product update(int id, Product newProduct) {
        Product toReturn = null;

        for (int i = 0; i < this.products.size(); ++i) {
            Product currentProduct = this.products.get(i);
            if (currentProduct.getId() == id) {
                currentProduct.setCategory(newProduct.getCategory());
                currentProduct.setName(newProduct.getName());
                currentProduct.setPrice(newProduct.getPrice());
            }
        }

        return toReturn;
    }

    public Product remove(int id) {
        return this.products.remove(id);
    }

}
