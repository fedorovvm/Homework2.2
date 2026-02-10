package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private Map<String, List<Product>> products = new LinkedHashMap<>();

    public void addingProductToTheBasket(Product product) {
        products.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
        System.out.println("product = " + product);
    }

    public double gettingTotalCostOfTheBasket() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public void printsTheContentsOfTheBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        long content = products.values().stream()
                .flatMap(Collection::stream)
                .count();

        long specialCount = getSpecialCount();

        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + gettingTotalCostOfTheBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean searchProduct(String titleProduct) {
        return products.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> product != null &&
                        product.getTitle().equalsIgnoreCase(titleProduct));
    }

    public void clearBasket() {
        products.clear();
    }

    public Map<String, Product> removeTheProduct(String title) {
        Map<String, Product> removedProducts = new HashMap<>();

        if (products == null || title == null) {
            return removedProducts;
        }

        List<Product> toRemove = products.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product != null &&
                        product.getTitle() != null &&
                        product.getTitle().equals(title))
                .collect(Collectors.toList());

        toRemove.forEach(product -> removedProducts.put(product.getTitle(), product));

        products.values().forEach(list -> list.removeIf(product ->
                product != null &&
                        product.getTitle() != null &&
                        product.getTitle().equals(title)));

        products.entrySet().removeIf(entry -> entry.getValue().isEmpty());

        if (removedProducts.isEmpty()) {
            System.out.println("Товар с названием '" + title + "' не найден.");
        }

        return removedProducts;
    }

    public void printBasket() {
        System.out.println(products);
    }
}

