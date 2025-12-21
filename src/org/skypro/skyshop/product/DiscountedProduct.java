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

    public static void checkBasicPrice(double basicPrice) throws IllegalArgumentException {
        if (basicPrice < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkPercentDiscount(int percentDiscount) throws IllegalArgumentException {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException();
        }
    }

}
