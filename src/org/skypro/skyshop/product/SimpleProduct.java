package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(String title, int price) {
        super(title);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + ": " + price;
    }
    public boolean isSpecial () {
        return false;
    }
    @Override
    public String gettingContentType() {
        return "SIMPLEPRODUCT";
    }

    public String gettingSearchTerm() {
        return super.gettingSearchTerm();
    }

    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}

