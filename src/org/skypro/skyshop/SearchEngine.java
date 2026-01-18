package org.skypro.skyshop;
import com.sun.source.tree.Tree;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String, Searchable> searchables;
    private int currentSize;

    public SearchEngine(int size) {
        this.searchables = new HashMap<>();
        this.currentSize = 0;
    }

    public Map<String, Searchable> search(String searchString) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable n : searchables.values()) {
            if (n.gettingSearchTerm().contains(searchString)) {
                results.put(n.getTitle(), n);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            return;
        }
        searchables.put(searchable.getTitle(), searchable);
        currentSize++;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Search string is null or empty");
        }

        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable n : searchables.values()) {
            String term = n.gettingSearchTerm().toLowerCase();
            String searchLower = search.toLowerCase();
            int occurrences = countOccurrences(term, searchLower);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestResult = n;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }

        System.out.println("Наиболее подходящий вариант поиска '" + search + "' = " + bestResult);
        return bestResult;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
