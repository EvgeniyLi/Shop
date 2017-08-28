package com.project.lyzohubov.productscollection;

import com.project.lyzohubov.entity.Laptop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;


public class ListCopyOnWriteTest {

    private ListCopyOnWrite<Laptop> collections = new ListCopyOnWrite<>();

    @Test
    public void shouldGetOldIteratorByAddNewElement() {
        Laptop laptop1 = new Laptop(1, "Lenovo", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "Lg", new BigDecimal("4"), 12, 33);
        collections.add(laptop1);
        collections.add(laptop2);
        Iterator<Laptop> iterator = collections.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            collections.add(laptop3);
            assertEquals(laptop2, iterator.next());
        }
    }
}

