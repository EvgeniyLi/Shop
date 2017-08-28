package com.project.lyzohubov.commands;

import com.project.lyzohubov.entity.Basket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandShowingLastFiveProductTest {
    private Basket basket = new Basket();

    @Before
    public void setUp() throws Exception {
        String productHp = "Hp";
        String productSamsung = "Samsung";
        String productLg = "Lg";
        String productDell = "Dell";
        String productAsus = "Asus";
        String productXiomi = "Xiomi";
        String productRazor = "Razor";
        String productLenovo = "Lenovo";

        this.basket.getLastFiveProducts().put(productHp, null);
        this.basket.getLastFiveProducts().put(productSamsung, null);
        this.basket.getLastFiveProducts().put(productLg, null);
        this.basket.getLastFiveProducts().put(productDell, null);
        this.basket.getLastFiveProducts().put(productAsus, null);
        this.basket.getLastFiveProducts().put(productXiomi, null);
        this.basket.getLastFiveProducts().put(productRazor, null);
        this.basket.getLastFiveProducts().put(productLenovo, null);
    }

    @Test
    public void shouldLastFiveElementInList() {
        this.basket.showLastFive();
        assertEquals(basket.getLastFiveProducts().size(), 5);
    }
}
