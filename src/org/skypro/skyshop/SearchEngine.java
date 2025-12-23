package org.skypro.skyshop;

public class SearchEngine {
    private static int currentSize;
    private static Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        currentSize = 0;
    }

    public Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int number = 0;
        for (Searchable n : searchables)
            if (n.gettingSearchTerm().contains(searchString)) {
                results[number++] = n;
                if (number == 5) break;
            }
        return results;
    }

    public void add(Searchable searchable) {
        if (currentSize <= searchables.length) {
            searchables[currentSize] = searchable;
            currentSize++;
        }
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
