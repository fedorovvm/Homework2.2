package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        basket.addingProductToTheBasket("Рубашка", 1000);
        basket.addingProductToTheBasket("Часы", 5000);
        basket.addingProductToTheBasket("Картина", 3000);
        basket.addingProductToTheBasket("Ремень", 2000);
        basket.addingProductToTheBasket("Куртка", 10000);
        basket.addingProductToTheBasket("Куртка", 10000);
        basket.gettingTotalCostOfTheBasket();
        basket.printsTheContentsOfTheBasket();
        basket.searchProduct("Часы");
        basket.clearBasket();
        basket.gettingTotalCostOfTheBasket();
        basket.printsTheContentsOfTheBasket();
        basket.searchProduct("Часы");
    }
}