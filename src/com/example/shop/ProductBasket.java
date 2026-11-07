package com.example.shop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                removed.add(product);
            }
        }
        return removed;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public int countSpecialProducts() {
        int count = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printBasket() {
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }
}