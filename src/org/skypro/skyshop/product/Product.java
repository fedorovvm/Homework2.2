package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    final String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

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

