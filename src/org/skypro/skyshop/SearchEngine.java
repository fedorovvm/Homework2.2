package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;

public class SearchEngine {
    private static int currentSize;
    private static LinkedList<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
        this.currentSize = 0;
    }

    public LinkedList<Searchable> search(String searchString) {
        LinkedList <Searchable> results = new LinkedList<>();
        int number = 0;
        for (Searchable n : searchables)
            if (n.gettingSearchTerm().contains(searchString)) {
                results.add(number++, n);
            }
        return results;
    }

    public void add(Searchable searchable) {
            searchables.add(searchable);
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        int number;
        int best = 0;
        int index;
        int indexSubstring;
        String str;
        Searchable bestResult = null;
        for (Searchable n : searchables) {
            str = n.gettingSearchTerm().toLowerCase();
            number = 0;
            index = 0;
            indexSubstring = str.indexOf(search.toLowerCase(), index);

            while (indexSubstring != -1) {
                number++;
                index = indexSubstring + search.length();
                indexSubstring = str.indexOf(search.toLowerCase(), index);
                if (number > best) {
                    best = number;
                    bestResult=n;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        System.out.println("Наиболее подходящий варинат поиска "  + search + " = " + bestResult);
        return bestResult;
    }
}
