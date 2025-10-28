package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final double basicPrice;
    private final int percentDiscount;

    public DiscountedProduct(String title, double basicPrice, int percentDiscount) {
        super(title);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;

    }
    @Override
    public int getPrice() {
        return (int)(basicPrice-basicPrice*percentDiscount/100);
    }

    @Override
    public String toString() {
        return title + " со скидкой: " + getPrice() + " ( " + percentDiscount + "% )";
    }

    public boolean isSpecial () {
        return true;
    }
}
