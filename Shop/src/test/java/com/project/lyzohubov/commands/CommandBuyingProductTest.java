package com.project.lyzohubov.commands;


import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CommandBuyingProductTest {

    private HashMap<BigDecimal, LocalDateTime> treeMapInfo = new HashMap<>();

    private int quantity;
    private BigDecimal counterLast;

    @Before
    public void setUp() throws Exception {
        quantity = 4;
        counterLast = new BigDecimal("2");

    }

    @Test
    public void shouldBuyProductAfterGettingProductList() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime expected3 = localDateTime;

        BigDecimal counter = BigDecimal.ZERO;
        counterLast = counterLast.multiply(BigDecimal.valueOf(quantity));

        counter = counter.add(counterLast);
        treeMapInfo.put(counter, localDateTime);

        BigDecimal expected = new BigDecimal("8");
        BigDecimal expected2 = new BigDecimal("8");

        assertEquals(expected, counterLast);
        assertEquals(expected2, counter);

        assertThat(treeMapInfo, IsMapContaining.hasEntry(expected, expected3));
        assertThat(treeMapInfo.size(), not(0));
    }
}
