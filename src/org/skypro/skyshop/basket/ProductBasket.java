package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> products = new LinkedHashMap<>();

    public void addingProductToTheBasket(Product product) {
        products.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
        System.out.println("product = " + product);
    }

    public double gettingTotalCostOfTheBasket() {
        double totalCostOfTheBasket = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalCostOfTheBasket += product.getPrice();
            }
        }
        return totalCostOfTheBasket;
    }

    public void printsTheContentsOfTheBasket() {
        int content = 0;
        int sumSpecialProdukt = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    content++;
                    if (product.isSpecial()) {
                        sumSpecialProdukt++;
                    }
                }
            }
        }

        System.out.println("Итого: " + gettingTotalCostOfTheBasket());
        System.out.println("Специальных товаров: " + sumSpecialProdukt);
    }

    public boolean searchProduct(String titleProduct) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.getTitle().equalsIgnoreCase(titleProduct)) {
                    System.out.println(titleProduct + " уже есть в корзине.");
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public Map<String, Product> removeTheProduct(String title) {
        Map<String, Product> removedProducts = new HashMap<>();

        if (products == null || title == null) {
            return removedProducts;
        }

        Iterator<List<Product>> listIterator = products.values().iterator();
        while (listIterator.hasNext()) {
            List<Product> productList = listIterator.next();

            Iterator<Product> productIterator = productList.iterator();
            while (productIterator.hasNext()) {
                Product product = productIterator.next();
                if (product != null && product.getTitle() != null && product.getTitle().equals(title)) {
                    removedProducts.put(product.getTitle(), product);
                    productIterator.remove();
                }
            }

            if (productList.isEmpty()) {
                listIterator.remove();
            }
        }

        if (removedProducts.isEmpty()) {
            System.out.println("Товар с названием '" + title + "' не найден.");
        }

        return removedProducts;
    }

    public void printBasket() {
        System.out.println(products);
    }
}

