package com.project.lyzohubov.entity;

import com.project.lyzohubov.constants.CommandConstant;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class Basket {

    private TreeMap<LocalDateTime, Order> treeMapInfo = new TreeMap<>();

    public void addToTreeMapInfo(LocalDateTime localDateTime, Order order) {
        treeMapInfo.put(localDateTime, order);
    }

    private HashMap<String, Integer> lastFiveProducts = new LinkedHashMap<String, Integer>() {

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 5;
        }
    };

    public TreeMap<LocalDateTime, Order> getTreeMapInfo() {
        return treeMapInfo;
    }

    public HashMap<String, Integer> getLastFiveProducts() {
        return lastFiveProducts;
    }

    public void showHistoryPurchased() {
        if (treeMapInfo.isEmpty()) {
            System.out.println(CommandConstant.HISTORY_IS_EMPTY);
        }
        for (Map.Entry entry : treeMapInfo.entrySet()) {
            System.out.println(entry.getKey() + "" + entry.getValue());
        }
    }


    public void addProductInBasket(String laptopId, int quantity) {
        lastFiveProducts.put(laptopId, quantity);
        System.out.println(CommandConstant.ADD_PRODUCT);
    }

    public void showBasket(LinkedHashMap<String, Integer> shopBasket) {
        if (shopBasket.isEmpty()) {
            System.out.println(CommandConstant.BASKET_IS_EMPTY);
        }
        for (Object objects : shopBasket.entrySet()) {
            System.out.println(objects);
        }
        System.out.println(CommandConstant.ALL_ADDED_PRODUCT);
    }

    public void showLastFive() {
        if (lastFiveProducts.isEmpty()) {
            System.out.println(CommandConstant.BASKET_IS_EMPTY);

        }
        for (Map.Entry<String, Integer> entry : lastFiveProducts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(CommandConstant.SHOW_FIVE_PRODUCT);
    }


    public void showPeriod(LocalDateTime firstTime, LocalDateTime secondTime) {

        if (treeMapInfo.isEmpty()) {
            System.out.println(CommandConstant.BASKET_IS_EMPTY);
        }


        for (Map.Entry<LocalDateTime, Order> entry : treeMapInfo.entrySet()) {
            LocalDateTime getLocalDate = entry.getKey();
            Order order = entry.getValue();

            if (getLocalDate.isAfter(firstTime) && getLocalDate.isBefore(secondTime)) {
                System.out.println(getLocalDate + "" + order);
            }
            if (getLocalDate.isAfter(secondTime) && getLocalDate.isBefore(firstTime)) {
                System.out.println(getLocalDate + "" + order);
            }
        }

    }

    public Map.Entry<LocalDateTime, Order> currentDay(LocalDateTime inputTime) {
        if (treeMapInfo.isEmpty()) {
            System.out.println(CommandConstant.BASKET_IS_EMPTY);
        }

        LocalDateTime afterTime;
        LocalDateTime beforeTime;

        if (treeMapInfo.lowerEntry(inputTime) == null) {
            return treeMapInfo.higherEntry(inputTime);
        } else {
            beforeTime = treeMapInfo.lowerEntry(inputTime).getKey();
        }
        if (treeMapInfo.higherEntry(inputTime) == null) {
            return treeMapInfo.lowerEntry(inputTime);
        } else {
            afterTime = treeMapInfo.higherEntry(inputTime).getKey();
        }
        return foundNearestDate(afterTime, beforeTime, inputTime);
    }


    private Map.Entry<LocalDateTime, Order> foundNearestDate(LocalDateTime inputTime, LocalDateTime afterTime, LocalDateTime beforeTime) {
        if (Duration.between(afterTime, inputTime).getSeconds() < Duration.between(inputTime, beforeTime).getSeconds()) {
            return treeMapInfo.lowerEntry(inputTime);
        } else {
            return treeMapInfo.higherEntry(inputTime);
        }
    }

}





