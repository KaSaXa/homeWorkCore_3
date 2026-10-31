package com.example.shop;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найден подходящий результат для поискового запроса: \"" + search + "\"");
    }
}