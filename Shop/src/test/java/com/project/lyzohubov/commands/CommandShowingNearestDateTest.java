package com.project.lyzohubov.commands;

import com.project.lyzohubov.entity.Basket;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class CommandShowingNearestDateTest {
    private LocalDateTime dateTimeFirst;
    private LocalDateTime dateTimeSecond;
    private LocalDateTime dateTimeThird;
    private LocalDateTime dateTimeFour;
    private Basket basket = new Basket();

    @Before
    public void setUp() throws Exception {
        String str = "1986-04-08 12:30";
        String str2 = "1986-04-08 12:35";
        String str3 = "1986-04-08 12:45";
        String str4 = "1986-04-08 12:55";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        dateTimeFirst = LocalDateTime.parse(str, formatter);
        dateTimeSecond = LocalDateTime.parse(str2, formatter);
        dateTimeThird = LocalDateTime.parse(str3, formatter);
        dateTimeFour = LocalDateTime.parse(str4, formatter);

        this.basket.getTreeMapInfo().put(dateTimeFirst, null);
        this.basket.getTreeMapInfo().put(dateTimeSecond, null);
        this.basket.getTreeMapInfo().put(dateTimeThird, null);
        this.basket.getTreeMapInfo().put(dateTimeFour, null);
    }

    @Test
    public void shouldGettingCurrentDateAfterInputGivenDate() {
        LocalDateTime expected = dateTimeThird;
        assertEquals(expected, basket.currentDay(dateTimeFour).getKey());
    }
}
