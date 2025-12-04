package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    final String title;


    public Product(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String gettingContentType() {
        return "PRODUCT";
    }
    public String gettingSearchTerm() {
        return getTitle();
    }
    @Override
    public String getStringRepresentation() {
        return gettingSearchTerm() + " - " + gettingContentType();
    }
}

