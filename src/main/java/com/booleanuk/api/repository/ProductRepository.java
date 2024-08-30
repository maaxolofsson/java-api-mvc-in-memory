package com.booleanuk.api.repository;

import com.booleanuk.api.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public Product add(Product newProduct) {
        Product actualNewProduct = new Product(newProduct.getName(), newProduct.getCategory(), newProduct.getPrice());
        this.products.add(actualNewProduct);
        return this.products.stream().
                filter(product -> product.getId() == actualNewProduct.getId()).
                findFirst().orElse(null);
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
