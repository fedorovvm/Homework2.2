package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {

    private static LinkedList<Product> products = new LinkedList<>();

     public void addingProductToTheBasket(Product product) {
         products.add(product);
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
        products.clear();
    }

    public LinkedList<Product> removeTheProduct(String title) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if (product != null && product.getTitle().equals(title)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }

        return removedProducts;
    }

    public static void printBacket() {
        System.out.println(products);
    }
}

