package com.example.shop;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable a, Searchable b) {
        int byLength = Integer.compare(b.getName().length(), a.getName().length());
        if (byLength != 0) {
            return byLength;
        }
        return a.getName().compareTo(b.getName());
    }
}