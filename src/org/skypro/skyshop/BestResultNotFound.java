package org.skypro.skyshop;

public class BestResultNotFound extends Throwable {
    private String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound { Для поискового запроса '" + search + "' не нашлось подходящей статьи }";
    }
}
