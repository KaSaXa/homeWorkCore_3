package com.example.shop;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> items = new LinkedList<>();

    public void add(Searchable item) {
        if (item == null) {
            return;
        }
        items.add(item);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            if (item.getSearchTerm().contains(query)) {
                result.put(item.getName(), item);
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