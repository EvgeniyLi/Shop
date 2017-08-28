package com.project.lyzohubov.entity;

import com.project.lyzohubov.productscollection.ProductsCollection;

import java.math.BigDecimal;

public class Repository {
    private ProductsCollection<Laptop> products = new ProductsCollection<>();
    public Repository() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("12"), 122, 260);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("23"), 132, 234);
        Laptop laptop3 = new Laptop(3, "Lg", new BigDecimal("55"), 132, 243);
        Laptop laptop4 = new Laptop(4, "Lenovo", new BigDecimal("55"), 132, 243);
        Laptop laptop5 = new Laptop(5, "Asus", new BigDecimal("2"), 132, 243);
        Laptop laptop6 = new Laptop(6, "Razer", new BigDecimal("3"), 132, 243);
        Laptop laptop7 = new Laptop(7, "Xiomi", new BigDecimal("4"), 132, 243);
        Laptop laptop8 = new Laptop(8, "Dell", new BigDecimal("5"), 132, 243);

        products.add(laptop1);
        products.add(laptop2);
        products.add(laptop3);
        products.add(laptop4);
        products.add(laptop5);
        products.add(laptop6);
        products.add(laptop7);
        products.add(laptop8);
    }

    public ProductsCollection<Laptop> getProduct() {
        return products;
    }
}

