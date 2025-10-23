package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private static final Product[] products = new Product[5];

     public void addingProductToTheBasket(String title, int price) {
        int e = 0;
        for (Product product : products) {
            if (product != null) {
                e++;
            } else if (product == null) {
                products[e] = new Product(title, price);
                break;
            }
            if (e == products.length) {
                System.out.println("Невозможно добавить продукт.");
            }
        }
    }

    public int gettingTotalCostOfTheBasket() {
        int totalCostOfTheBasket = 0;
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
        for (Product product : products)
            if (product != null) {
                System.out.println(product);
                content++;
            } else break;
        if (content == 0) {
                System.out.println("В корзине пусто.");
            }
        System.out.println("Итого: " + gettingTotalCostOfTheBasket());
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

