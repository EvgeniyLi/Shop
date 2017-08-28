package com.project.lyzohubov.productscollection;

import com.project.lyzohubov.entity.Laptop;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductsSetTest {
    private ProductsSet<Laptop> collectionsShop = new ProductsSet<>();
    private ProductsSet<Laptop> newCollections = new ProductsSet<>();

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterAddingElements() {
        Laptop laptop1 = new Laptop(1, "Samsung", new BigDecimal("55"), 12, 244);
        collectionsShop.add(laptop1);
        collectionsShop.add(laptop1);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterAddingAllElements() {
        Laptop laptop1 = new Laptop(1, "Samsung", new BigDecimal("55"), 12, 244);;
        collectionsShop.add(laptop1);
        newCollections.add(laptop1);
        newCollections.addAll(collectionsShop);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterSettingElement() {
        Laptop laptop1 = new Laptop(1, "Samsung", new BigDecimal("55"), 12, 244);
        collectionsShop.add(laptop1);
        collectionsShop.set(1, laptop1);
    }


    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterAddingElementByIndex() {
        Laptop laptop1 = new Laptop(1, "Samsung", new BigDecimal("55"), 12, 244);
        collectionsShop.add(laptop1);
        collectionsShop.add(1, laptop1);
    }


    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterAddingCollectionByIndex() {
        Laptop laptop1 = new Laptop(1, "Samsung", new BigDecimal("55"), 12, 244);
        collectionsShop.add(laptop1);
        newCollections.add(laptop1);
        newCollections.addAll(0,collectionsShop);
    }
}