package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import java.util.Arrays;
import static org.skypro.skyshop.SearchEngine.add;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("    ", -1);
        try {
            Product.checkTitle(product1.getTitle());
        } catch (IllegalArgumentException e) {
            System.out.println("Неверное наименование товара");
        }
        try {
            SimpleProduct.checkPrice(product1.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указана цена товара");
        }

        DiscountedProduct product2 = new DiscountedProduct("Рубашка", -1, 101);
        try {
            DiscountedProduct.checkBasicPrice(product2.getBasicPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указана базовая цена товара");
        }
        try {
            DiscountedProduct.checkPercentDiscount(product2.getPercentDiscount());
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указан процент скидки товара");
        }

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
        basket.clearBasket();
        basket.gettingTotalCostOfTheBasket();
        basket.printsTheContentsOfTheBasket();
        basket.searchProduct("Часы");

        SearchEngine searchEngine = new SearchEngine(10);
        add(new SimpleProduct("Ноутбук", 50000));
        add(new DiscountedProduct("Рубашка Рубашка Рубашка", 1000, 5));
        add(new FixPriceProduct("Чехол для смартфона"));
        add(new SimpleProduct("Часы", 5000));
        add(new SimpleProduct("Часы", 3000));
        add(new DiscountedProduct("Книга", 900, 10));

        add(new Article("Ноутбук", "Китайский Ноутбук"));
        add(new Article("Часы", "Швейцарские Часы"));
        add(new Article("Книга", "Занимательная книга"));
        add(new Article("Книга 'Война и мир'", "Всем книгам книга"));

        System.out.println("Arrays.toString(SearchEngine.search(\"Часы\")) = " + Arrays.toString(SearchEngine.search("Часы")));
        System.out.println("Arrays.toString(SearchEngine.search(\"Рубашка\")) = " + Arrays.toString(SearchEngine.search("Рубашка")));
        System.out.println("Arrays.toString(SearchEngine.search(\"Книга\")) = " + Arrays.toString(SearchEngine.search("Книга")));

        try {
            SearchEngine.searchBestResult("Книга");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }
}