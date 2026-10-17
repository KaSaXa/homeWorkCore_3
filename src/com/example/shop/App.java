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
                "Свежемолотый кофе раскрывает вкус лучше."));

        System.out.println();
        System.out.println("Поиск: \"Хлеб\"");
        System.out.println(Arrays.toString(engine.search("Хлеб")));

        System.out.println();
        System.out.println("Поиск: \"Кофе\"");
        System.out.println(Arrays.toString(engine.search("Кофе")));

        System.out.println();
        System.out.println("Поиск: \"сыр\"");
        System.out.println(Arrays.toString(engine.search("сыр")));

        System.out.println();
        System.out.println("Поиск: \"нет-такого\"");
        System.out.println(Arrays.toString(engine.search("нет-такого")));
    }
}