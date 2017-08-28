package com.project.lyzohubov.productscollection;


import com.project.lyzohubov.entity.Laptop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductsCollectionTest {
    private ProductsCollection<Laptop> collectionsGoods = new ProductsCollection<>();

    @Test
    public void shouldGetExpectedSizeAfterAddingElements() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        int expected = 2;
        assertEquals(expected, collectionsGoods.size());
    }

    @Test
    public void shouldGetExpectedSizeAfterModifyingListByAddAndRemoveMethods() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.remove(laptop1);
        int expected = 1;
        assertEquals(expected, collectionsGoods.size());
    }

    @Test
    public void shouldGetExpectedElementsFromIteratorByGivenPredicate() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "bill", new BigDecimal("3"), 12, 33);

        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.add(laptop3);

        Predicate<Laptop> predicatePlate = plate -> "Jeck".equals(plate.getName());

        collectionsGoods.setPredicate(predicatePlate);
        Iterator<Laptop> iterator = collectionsGoods.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(laptop2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldGetIteratorWithExpectedNumberOfElements() {
        int step = 0;
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "bill", new BigDecimal("3"), 12, 33);

        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.add(laptop3);
        Iterator<Laptop> iterator = collectionsGoods.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            step++;
        }
        int expected = 3;
        assertEquals(expected, step);

    }

    @Test
    public void shouldGetEmptyIterator() {
        Iterator<Laptop> iterator = collectionsGoods.iterator();
        boolean expected = false;
        assertEquals(expected, iterator.hasNext());
    }

    @Test
    public void shouldGetNotEmptyIterator() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        Iterator<Laptop> iterator = collectionsGoods.iterator();
        boolean expected = true;
        assertEquals(expected, iterator.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldGetExceptionAfterTryingToGetElementByIndex() {
        collectionsGoods.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldGetExceptionAfterTryingToGetIndexIsLargeSize() throws IndexOutOfBoundsException {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.get(11);
    }

    @Test
    public void shouldGetElementByIndex() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "bill", new BigDecimal("3"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.add(laptop3);
        Laptop expected = laptop2;
        assertEquals(expected, collectionsGoods.get(1));
    }


    @Test
    public void shouldExpectedSetElementAfterAddedElement() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "bill", new BigDecimal("3"), 12, 33);
        collectionsGoods.add(laptop1);
        collectionsGoods.add(laptop2);
        collectionsGoods.add(laptop3);
        Laptop expected = laptop1;
        collectionsGoods.set(1, laptop1);
        assertEquals(expected, collectionsGoods.get(1));
    }

    @Test
    public void shouldGetExpectedSizeAfterRemovingElementByIndex() {
        Laptop laptop1 = new Laptop(1, "Kolya", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Jeck", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(3, "bill", new BigDecimal("3"), 12, 33);
        collectionsGoods.add(0, laptop1);
        collectionsGoods.add(1, laptop2);
        collectionsGoods.add(2, laptop3);
        collectionsGoods.remove(1);
        int expected = 2;
        assertEquals(expected, collectionsGoods.size());
    }
}
