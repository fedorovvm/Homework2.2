package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int fixPrice = 300;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }
    @Override
    public String toString() {
        return title + " c фиксированной ценой: " + "Фиксированная цена " + fixPrice;
    }

    public boolean isSpecial () {
        return true;
    }

}
