package com.project.lyzohubov.productscollection;

import java.util.ArrayList;
import java.util.Collection;

public class ProductsSet<E> extends ArrayList<E> {

    ProductsSet() {
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            throw new IllegalStateException();
        } else {
            return super.add(element);
        }
    }

    @Override
    public void add(int index, E element) {
        if (contains(element)) {
            throw new IllegalStateException();
        } else {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (alreadyExistAnyFromCollection(collection)) {
            throw new IllegalStateException();
        } else {
            return super.addAll(collection);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (alreadyExistAnyFromCollection(collection)) {
            throw new IllegalStateException();
        } else {
            return super.addAll(index, collection);
        }
    }

    @Override
    public E set(int index, E element) {
        if (contains(element)) {
            throw new IllegalStateException();
        }
        return super.set(index, element);
    }

    private boolean alreadyExistAnyFromCollection(Collection<? extends E> collection) {
        for (E e : collection) {
            if (contains(e)) {
                throw new IllegalStateException();
            }
        }
        return false;
    }
}

