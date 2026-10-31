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

    public Searchable searchBest(String query) throws BestResultNotFound {
        Searchable best = null;
        int bestCount = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            int count = countOccurrences(item.getSearchTerm(), query);
            if (count > bestCount) {
                bestCount = count;
                best = item;
            }
        }

        if (best == null) {
            throw new BestResultNotFound(query);
        }
        return best;
    }

    private int countOccurrences(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        int found = text.indexOf(substring, index);
        while (found != -1) {
            count++;
            index = found + substring.length();
            found = text.indexOf(substring, index);
        }
        return count;
    }
}