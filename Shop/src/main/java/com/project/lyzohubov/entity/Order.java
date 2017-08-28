package com.project.lyzohubov.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private ArrayList<OrderItem> orderList;

    public Order() {

    }

    public void add(String getName, int getQuantity, BigDecimal getCounterLast) {
        orderList = new ArrayList<>();
        orderList.add(new OrderItem(getName, getQuantity, getCounterLast));
    }

    @Override
    public String toString() {
        return " Order " + "Product :" + orderList;
    }

    private class OrderItem {

        private String name;
        private int quantity;
        private BigDecimal counterLast;

        OrderItem(String name, int quantity, BigDecimal counterLast) {
            this.name = name;
            this.quantity = quantity;
            this.counterLast = counterLast;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + counterLast;
        }
    }
}
