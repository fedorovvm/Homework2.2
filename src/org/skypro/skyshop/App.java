package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        try {
            SimpleProduct product1 = new SimpleProduct("Ноутбук", 50000);
            product1.checkTitle(product1.getTitle());
            product1.checkPrice(product1.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product2 = new DiscountedProduct("Рубашка", 1000, 100);
            product2.checkBasicPrice(product2.getBasicPrice());
            product2.checkPercentDiscount(product2.getPercentDiscount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Product product1 = new SimpleProduct("Ноутбук", 50000);
        Product product2 = new DiscountedProduct("Рубашка", 1000, 100);
        Product product3 = new FixPriceProduct("Чехол для смартфона");
        Product product4 = new SimpleProduct("Часы", 5000);
        Product product5 = new DiscountedProduct("Книга", 900, 10);
        Product product6 = new FixPriceProduct("Чехол для смартфона");

        basket.addingProductToTheBasket(product1);
        basket.addingProductToTheBasket(product2);
        basket.addingProductToTheBasket(product3);
        basket.addingProductToTheBasket(product4);
        basket.addingProductToTheBasket(product5);
        basket.addingProductToTheBasket(product6);

        basket.gettingTotalCostOfTheBasket();
        basket.printsTheContentsOfTheBasket();
        basket.searchProduct("Часы");
        System.out.println(basket.removeTheProduct("Часы"));
        ProductBasket.printBacket();
        System.out.println(basket.removeTheProduct("Тапочки"));
        ProductBasket.printBacket();
        basket.clearBasket();
        basket.gettingTotalCostOfTheBasket();
        basket.printsTheContentsOfTheBasket();
        basket.searchProduct("Часы");


        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Ноутбук", 50000));
        searchEngine.add(new DiscountedProduct("Рубашка", 1000, 5));
        searchEngine.add(new FixPriceProduct("Чехол для смартфона"));
        searchEngine.add(new SimpleProduct("Часы", 5000));
        searchEngine.add(new SimpleProduct("Часы", 3000));
        searchEngine.add(new DiscountedProduct("Книга", 900, 10));

        searchEngine.add(new Article("Ноутбук", "Китайский Ноутбук"));
        searchEngine.add(new Article("Часы", "Швейцарские Часы"));
        searchEngine.add(new Article("Книга", "Занимательная книга"));
        searchEngine.add(new Article("Книга 'Война и мир'", "Всем книгам книга"));

        System.out.println("Arrays.toString(SearchEngine.search(\"Часы\")) = " + Arrays.toString(new LinkedList[]{searchEngine.search("Часы")}));
        System.out.println("Arrays.toString(SearchEngine.search(\"Рубашка\")) = " + Arrays.toString(new LinkedList[]{searchEngine.search("Рубашка")}));
        System.out.println("Arrays.toString(SearchEngine.search(\"Книга\")) = " + Arrays.toString(new LinkedList[]{searchEngine.search("Книга")}));

        try {
            searchEngine.searchBestResult("Книга");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }
}