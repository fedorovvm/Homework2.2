package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final double basicPrice;
    private final int percentDiscount;

    public double getBasicPrice() {
        return basicPrice;
    }
    public int getPercentDiscount() {
        return percentDiscount;
    }

    public DiscountedProduct(String title, double basicPrice, int percentDiscount) throws IllegalArgumentException {
        super(title);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;

        if (basicPrice < 0) {
            throw new IllegalArgumentException("Неверно указана базовая цена товара");
        }
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Неверно указан процент скидки товара");
        }

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


    public String gettingSearchTerm() {
        return super.getTitle();
    }
    @Override
    public String gettingContentType() {
        return "DISCOUNTPRODUCT";
    }


    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    public void checkBasicPrice(double basicPrice) throws IllegalArgumentException {
        if (basicPrice < 0) {
            throw new IllegalArgumentException("Неверно указана базовая цена товара");
        }
    }

    public void checkPercentDiscount(int percentDiscount) throws IllegalArgumentException {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Неверно указан процент скидки товара");
        }
    }

}
