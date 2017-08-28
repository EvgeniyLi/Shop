package com.project.lyzohubov.services;

import com.project.lyzohubov.constants.CommandConstant;
import com.project.lyzohubov.dao.ProductDao;
import com.project.lyzohubov.entity.Laptop;
import com.project.lyzohubov.entity.Basket;
import com.project.lyzohubov.entity.Order;
import com.project.lyzohubov.productscollection.ProductsCollection;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    private BigDecimal counterLast = BigDecimal.ZERO;
    private ProductsCollection<Laptop> allProduct;
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter parsePattern = DateTimeFormatter.ofPattern(CommandConstant.YYYY_MM_DD_HH_MM);

    private LinkedHashMap<String, Integer> shopBasket = new LinkedHashMap<>();
    private Basket basket = new Basket();

    public void showAllProduct() {
        allProduct = productDao.getAllProduct();
        for (Laptop anAllProduct : allProduct) {
            System.out.println(anAllProduct);
        }
    }

    public void buySelectedProduct() {
        if (counterLast.compareTo(new BigDecimal("0.00")) == 0) {
            System.out.println(CommandConstant.NOTHING_TO_BUY);
            return;
        }
        System.out.println(CommandConstant.DATE_ORDER);
        String dateOrder = scanner.nextLine();
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(dateOrder, parsePattern);
        } catch (DateTimeException ex) {
            ex.getMessage();
        }
        BigDecimal counter = BigDecimal.ZERO;
        Order order = new Order();

        for (Map.Entry<String, Integer> aer : shopBasket.entrySet()) {
            String getName = aer.getKey();
            int quantity = aer.getValue();
            System.out.println("Your quantity is: " + aer.getValue() + " price: " + counterLast + " date " + dateTime);
            counterLast = counterLast.multiply(BigDecimal.valueOf(quantity));
            counter = counter.add(counterLast);
            System.out.println(getName);
            System.out.println("Total price: " + counterLast);
            System.out.println("");
            order.add(getName, quantity, counterLast);
        }
        basket.addToTreeMapInfo(dateTime, order);
        System.out.println("Total price: " + counter);
        System.out.println(CommandConstant.BOUGHT_PRODUCTS);
        shopBasket.clear();
        System.out.println(CommandConstant.BASKET_CLEARED);
    }

    public void addProductToBasket(String productName, int quantity) {
        allProduct = productDao.getAllProduct();
        if (productDao.checkExistProduct(productName)) {
            String laptopId = productName;
            shopBasket.put(laptopId, quantity);
            basket.addProductInBasket(laptopId, quantity);
            getShopList(laptopId);
        } else {
            System.out.println(CommandConstant.INPUT_INVALID);
        }
    }

    private void getShopList(String laptopId) {
        for (Laptop laptop : allProduct) {
            if (laptopId.equals(laptop.getName())) {
                counterLast = laptop.getPrice();
            }
        }
    }

    public void showBasket() {
        basket.showBasket(shopBasket);
    }

    public void showLastFiveProducts() {
        basket.showLastFive();
    }

    public void showPurchaseProduct() {
        basket.showHistoryPurchased();
    }

    public void showPeriodTime(LocalDateTime firstHour, LocalDateTime secondHour) {
        basket.showPeriod(firstHour, secondHour);
    }

    public Map.Entry<LocalDateTime, Order> showCurrentDate(LocalDateTime inputTime) {
        return basket.currentDay(inputTime);
    }
}





