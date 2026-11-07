package com.example.shop;

import java.util.List;

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
        System.out.println("=== Удаление существующего продукта: \"Сыр\" ===");
        List<Product> removed = basket.removeProductsByName("Сыр");
        System.out.println("Удалённые продукты:");
        for (Product p : removed) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Корзина после удаления:");
        basket.printBasket();

        System.out.println();
        System.out.println("=== Удаление несуществующего продукта: \"Шоколад\" ===");
        List<Product> removed2 = basket.removeProductsByName("Шоколад");
        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removed2) {
                System.out.println(p);
            }
        }
        System.out.println();
        System.out.println("Корзина после удаления:");
        basket.printBasket();

        System.out.println();
        System.out.println("=== Проверка валидации ===");
        try {
            new SimpleProduct("  ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new SimpleProduct("Товар", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            new DiscountedProduct("Скидочный", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        SearchEngine engine = new SearchEngine();
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
        System.out.println("=== Поиск: \"Кофе\" ===");
        List<Searchable> found = engine.search("Кофе");
        for (Searchable s : found) {
            System.out.println(s.getStringRepresentation());
        }

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
    }
}