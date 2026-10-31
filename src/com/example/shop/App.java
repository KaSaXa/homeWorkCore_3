package com.example.shop;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Сыр", 200, 20));
        basket.addProduct(new FixPriceProduct("Кружка"));
        basket.addProduct(new DiscountedProduct("Кофе", 500, 10));
        basket.addProduct(new SimpleProduct("Молоко", 80));
        basket.printBasket();

        System.out.println();
        System.out.println("=== Проверка валидации ===");

        try {
            new SimpleProduct("  ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new SimpleProduct(null, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new SimpleProduct("Товар", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Скидочный", -5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Скидочный", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        SearchEngine engine = new SearchEngine(20);
        engine.add(new SimpleProduct("Хлеб", 50));
        engine.add(new DiscountedProduct("Сыр", 200, 20));
        engine.add(new FixPriceProduct("Кружка"));
        engine.add(new DiscountedProduct("Кофе", 500, 10));
        engine.add(new SimpleProduct("Молоко", 80));
        engine.add(new Article("Как выбрать хлеб",
                "Обращайте внимание на состав и срок годности."));
        engine.add(new Article("Всё о сыре",
                "Сыр бывает твёрдый, мягкий и рассольный."));
        engine.add(new Article("Кофе дома",
                "Свежемолотый кофе раскрывает вкус лучше. Кофе нужно хранить в тёмном месте."));

        System.out.println();
        System.out.println("=== searchBest: результат найден ===");
        try {
            Searchable best = engine.searchBest("Кофе");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== searchBest: результат не найден ===");
        try {
            Searchable best = engine.searchBest("Шоколад");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Поиск в массиве (проверка) ===");
        System.out.println(Arrays.toString(engine.search("Кофе")));
    }
}