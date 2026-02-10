package org.skypro.skyshop;
import com.sun.source.tree.Tree;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;


    public SearchEngine(int size) {
        this.searchables = new HashSet<>(size);
    }

    public Set<Searchable> search(String searchString) {
        Comparator<Searchable> comparator = (a, b) -> {
            int lengthDiff = Integer.compare(b.getTitle().length(), a.getTitle().length());
            if (lengthDiff != 0) {
                return lengthDiff;
            }
            return a.getTitle().compareTo(b.getTitle());
        };

        return searchables.stream()
                .filter(n -> n.gettingSearchTerm().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            return;
        }
        searchables.add(searchable);
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound("Search string is null or empty");
        }

        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable n : searchables) {
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
