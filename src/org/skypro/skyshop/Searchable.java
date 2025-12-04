package org.skypro.skyshop;

public interface Searchable {
    String gettingSearchTerm();
    String gettingContentType();
    default String getStringRepresentation() {
        return this.gettingSearchTerm() + " - " + this.gettingContentType();
    }
}
