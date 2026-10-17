package com.example.shop;

public class SearchEngine {
    private final Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (item == null) {
            return;
        }
        if (size >= items.length) {
            return;
        }
        items[size] = item;
        size++;
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int found = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            if (item.getSearchTerm().contains(query)) {
                result[found] = item;
                found++;
                if (found == 5) {
                    break;
                }
            }
        }

        return result;
    }
}