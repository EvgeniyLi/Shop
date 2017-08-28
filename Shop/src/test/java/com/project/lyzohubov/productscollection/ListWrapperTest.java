package com.project.lyzohubov.productscollection;

import com.project.lyzohubov.entity.Laptop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class ListWrapperTest {

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionInUnmodifiableListWithSetElement() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(2, "Lg", new BigDecimal("4"), 12, 33);
        ListCopyOnWrite<Laptop> unmodifiableList = new ListCopyOnWrite<>();
        unmodifiableList.add(laptop1);
        unmodifiableList.add(laptop2);

        ListCopyOnWrite<Laptop> modifiableList = new ListCopyOnWrite<>();
        modifiableList.add(laptop1);
        modifiableList.add(laptop2);

        ListWrapper modifiableCollections = new ListWrapper(unmodifiableList, modifiableList);
        modifiableCollections.set(1, laptop3);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionInUnmodifiableListWithAddElement() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(2, "Lg", new BigDecimal("4"), 12, 33);
        ListCopyOnWrite<Laptop> unmodifiableList = new ListCopyOnWrite<>();
        unmodifiableList.add(laptop1);
        unmodifiableList.add(laptop2);

        ListCopyOnWrite<Laptop> modifiableList = new ListCopyOnWrite<>();
        modifiableList.add(laptop1);
        modifiableList.add(laptop2);

        ListWrapper modifiableCollections = new ListWrapper(unmodifiableList, modifiableList);
        modifiableCollections.add(1, laptop3);
    }

    @Test
    public void shouldGetIteratorInListWrapperByAddingElements() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        ListCopyOnWrite<Laptop> unmodifiableList = new ListCopyOnWrite<>();
        unmodifiableList.add(laptop1);
        unmodifiableList.add(laptop2);

        ListCopyOnWrite<Laptop> modifiableList = new ListCopyOnWrite<>();
        modifiableList.add(laptop1);
        modifiableList.add(laptop2);

        ListWrapper listWrapper = new ListWrapper(unmodifiableList, modifiableList);
        Iterator<Laptop> iterator = listWrapper.iterator();
        boolean expected = true;
        assertEquals(expected, iterator.hasNext());
    }

    @Test
    public void shouldGetElementAfterRemovingInModifiableList() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(2, "Lenovo", new BigDecimal("4"), 12, 33);

        ListCopyOnWrite<Laptop> unmodifiableList = new ListCopyOnWrite<>();
        unmodifiableList.add(laptop1);
        unmodifiableList.add(laptop2);

        ListCopyOnWrite<Laptop> modifiableList = new ListCopyOnWrite<>();
        modifiableList.add(laptop1);
        modifiableList.add(laptop3);

        ListWrapper listWrapper = new ListWrapper(unmodifiableList, modifiableList);
        assertEquals(laptop3, listWrapper.remove(2));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldGetExceptionAfterRemovingObject() {
        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(2, "Lenovo", new BigDecimal("4"), 12, 33);

        ListCopyOnWrite<Laptop> unmodifiableList = new ListCopyOnWrite<>();
        unmodifiableList.add(laptop1);
        unmodifiableList.add(laptop2);

        ListCopyOnWrite<Laptop> modifiableList = new ListCopyOnWrite<>();
        modifiableList.add(laptop3);

        ListWrapper listWrapper = new ListWrapper(unmodifiableList, modifiableList);
        listWrapper.remove(laptop1);
    }

}

