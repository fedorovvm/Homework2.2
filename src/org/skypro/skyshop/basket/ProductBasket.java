package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {

    private static final Product[] products = new Product[5];

    private static int size = 0;
     public void addingProductToTheBasket(Product product) {
         if (size >= products.length) {
             System.out.println("Невозможно добавить продукт.");
         } else if (products[size] == null && size <= products.length) {
             products[size] = product;
             size++;
         }
     }

    public double gettingTotalCostOfTheBasket() {
        double totalCostOfTheBasket = 0;
        for (Product product : ProductBasket.products) {
            if (product != null) {
                totalCostOfTheBasket += product.getPrice();
            } else {
                break;
            }
        }
        return totalCostOfTheBasket;
    }

    public void printsTheContentsOfTheBasket() {
        int content = 0;
        int sumSpecialProdukt = 0;
        for (Product product : products)
            if (product != null) {
                System.out.println(product);
                content++;
            } else break;
        if (content == 0) {
                System.out.println("В корзине пусто.");
            }
        for (Product product : products)
            if (product != null && product.isSpecial()) {
                sumSpecialProdukt++;
            }
        System.out.println("Итого: " + gettingTotalCostOfTheBasket());
        System.out.println("Специальных товаров: " + sumSpecialProdukt);
    }

    public boolean searchProduct(String titleProduct) {
        for (Product product : products) {
            if (product != null) {
                if (product.getTitle().equalsIgnoreCase(titleProduct)) {
                    System.out.println(titleProduct + " уже есть в корзине.");
                }
            }
        }
        return true;
    }

    public void clearBasket() {
        for (int i = 0; i < 5; i++) {
            products[i] = null;
        }
    }
}

