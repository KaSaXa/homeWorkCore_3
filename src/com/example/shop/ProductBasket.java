package com.example.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = products.remove(name);
        if (removed == null) {
            return new ArrayList<>();
        }
        return removed;
    }

    public double getTotalPrice() {
        double total = 0;
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int countSpecialProducts() {
        int count = 0;
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBasket() {
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }
}