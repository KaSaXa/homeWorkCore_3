package com.example.shop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Сыр", 200, 20));
        basket.addProduct(new FixPriceProduct("Кружка"));
        basket.addProduct(new DiscountedProduct("Кофе", 500, 10));
        basket.addProduct(new SimpleProduct("Молоко", 80));

        basket.printBasket();
    }
}