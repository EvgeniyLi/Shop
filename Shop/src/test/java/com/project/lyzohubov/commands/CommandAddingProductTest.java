package com.project.lyzohubov.commands;

import com.project.lyzohubov.dao.ProductDao;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CommandAddingProductTest {
    private ProductDao productDaoShop = new ProductDao();
    private HashMap<String, Integer> shopBasket = new HashMap<>();
    private int quantity;
    private String product;

    @Before
    public void setUp() throws Exception {
        quantity = 4;
        product = "Hp";
    }

    @Test
    public void shouldAddProductInBasketAfterCheckingProduct() {
        String laptopName = "Hp";
        assertTrue(productDaoShop.checkExistProduct(product));
        shopBasket.put(laptopName, quantity);
        assertThat(shopBasket, IsMapContaining.hasEntry("Hp", 4));
    }

    @Test
    public void shouldAddedInBasket() {
        int quantity = 4;
        String product = "Hp";
        assertTrue(productDaoShop.checkExistProduct(product));
        shopBasket.put(product, quantity);
        assertThat(shopBasket, IsMapContaining.hasEntry("Hp", quantity));
        assertThat(shopBasket.size(),not(0));
    }
    @Test
    public void shouldIsNotCorrectProductAfterInput(){
        String product="Gh";
        assertFalse(productDaoShop.checkExistProduct(product));
    }
}
