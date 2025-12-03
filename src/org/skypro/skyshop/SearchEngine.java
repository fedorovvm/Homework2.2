package org.skypro.skyshop;

public class SearchEngine {
    private static int currentSize;
    private static Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        currentSize = 0;
    }
        public static Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int number = 0;
        for (Searchable n : searchables)
            if (n.gettingSearchTerm().contains(searchString)) {
                results[number++] = n;
                if (number == 5) break;
            }
        return results;
    }

    public static void add(Searchable searchable) {
        if (currentSize <= searchables.length) {
            searchables[currentSize] = searchable;
            currentSize++;
        }
    }
}
