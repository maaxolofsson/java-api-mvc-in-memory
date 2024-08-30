package com.booleanuk.api.repository;

import com.booleanuk.api.model.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public Product add(Product newProduct) {
        // Check if name exists, if it does return null
        for (Product p : this.products) if (p.getName().equals(newProduct.getName())) return null;

        Product actualNewProduct = new Product(newProduct.getName(), newProduct.getCategory(), newProduct.getPrice());
        this.products.add(actualNewProduct);
        return this.products.stream().
                filter(product -> product.getId() == actualNewProduct.getId()).
                findFirst().orElse(null);
    }

    public ArrayList<Product> getAll(String category) {
        if (category == null || category.isEmpty()) {
            return this.products;
        }

        category = category.toLowerCase();
        ArrayList<Product> toReturn = new ArrayList<>();
        for (Product p : this.products) {
            if (p.getCategory().toLowerCase().equals(category)) toReturn.add(p);
        }
        return toReturn;
    }

    public Product getOne(int id) {
        return this.products.stream().
                filter(author -> author.getId() == id).
                findFirst().orElse(null);
    }

    public Product update(int id, Product newProduct) {
        Product toReturn = null;

        for (int i = 0; i < this.products.size(); ++i) {
            Product currentProduct = this.products.get(i);
            if (currentProduct.getId() == id) {
                currentProduct.setCategory(newProduct.getCategory());
                currentProduct.setName(newProduct.getName());
                currentProduct.setPrice(newProduct.getPrice());
                toReturn = currentProduct;
            }
        }

        return toReturn;
    }

    public Product remove(int id) {
        Product toReturn = null;
        for (int i = 0; i < this.products.size(); ++i) {
            if (this.products.get(i).getId() == id) {
                toReturn = this.products.get(i);
                this.products.remove(i);
                break;
            }
        }
        return toReturn;
    }

}
