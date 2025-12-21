package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    final String title;



    public Product(String title) throws IllegalArgumentException {
        this.title = title;
        if (title.isBlank()) {
            throw new IllegalArgumentException("Недопустимое наименование товара");
        }

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
    public void checkTitle(String title) throws IllegalArgumentException {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Недопустимое наименование товара");
        }

    }
}

