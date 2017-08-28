package com.project.lyzohubov.productscollection;

import java.util.*;

public class ListWrapper<E> implements List<E> {

    private ListCopyOnWrite<E> unmodifiableList;
    private ListCopyOnWrite<E> modifiableList;

    public ListWrapper(ListCopyOnWrite<E> unmodifiableList, ListCopyOnWrite<E> modifiableList) {
        this.unmodifiableList = unmodifiableList;
        this.modifiableList = modifiableList;
    }

    @Override
    public int size() {
        return unmodifiableList.size() + modifiableList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ModifiableIterator();
    }


    private class ModifiableIterator implements Iterator<E> {

        Iterator<E> unmodifiableIterator;
        Iterator<E> modifiableListIterator;

        private ModifiableIterator() {
            unmodifiableIterator = unmodifiableList.iterator();
            modifiableListIterator = modifiableList.iterator();
        }

        @Override
        public boolean hasNext() {
            return unmodifiableIterator.hasNext() || modifiableListIterator.hasNext();
        }

        @Override
        public E next() {
            if (unmodifiableIterator.hasNext()) {
                return unmodifiableIterator.next();
            }
            if (modifiableListIterator.hasNext()) {
                return modifiableListIterator.next();
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        System.arraycopy(unmodifiableList.toArray(), 0, objects, 0, unmodifiableList.size());
        System.arraycopy(modifiableList.toArray(), 0, objects, unmodifiableList.size(), modifiableList.size());
        return objects;
    }

    @Override
    public boolean add(E object) {
        return modifiableList.add(object);
    }

    @Override
    public boolean remove(Object object) {
        if (unmodifiableList.contains(object)) {
            throw new IllegalStateException();
        }
        return modifiableList.remove(object);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return modifiableList.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        checkValidIndex(index);
        return modifiableList.addAll(index, collection);
    }

    @Override
    public void clear() {
        if (unmodifiableList.isEmpty() || unmodifiableList == null) {
            throw new IllegalStateException();
        } else {
            modifiableList.clear();
        }
    }

    @Override
    public E get(int index) {
        checkValidIndex(index);
        return modifiableList.get(size() - index - 1);
    }

    @Override
    public E set(int index, E element) {
        checkValidIndex(index);
        return modifiableList.set(size() - index - 1, element);
    }

    @Override
    public void add(int index, E element) {
        checkValidIndex(index);
        modifiableList.add(size() - index - 1, element);
    }

    private void checkValidIndex(int index) {
        if (index < unmodifiableList.size()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public E remove(int index) {
        checkValidIndex(index);
        return modifiableList.remove(size() - index - 1);
    }

    @Override
    public int indexOf(Object object) {
        if (unmodifiableList.contains(object)) {
            throw new IllegalStateException();
        } else {
            return modifiableList.indexOf(object);
        }
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = modifiableList.lastIndexOf(object);
        if (index < 0) {
            return unmodifiableList.lastIndexOf(object);
        }
        return index + unmodifiableList.size();
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (unmodifiableList.contains(collection)) {
            throw new IllegalStateException();
        }
        return modifiableList.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (unmodifiableList.contains(collection)) {
            return false;
        }
        return modifiableList.removeAll(collection);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return modifiableList.containsAll(collection);
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (unmodifiableList.contains(objects)) {
            for (int i = 0; i < unmodifiableList.size(); i++) {
                objects[i] = unmodifiableList.toArray();
            }
            if (modifiableList.contains(objects)) {
                for (int i = 0; i < unmodifiableList.size(); i++) {
                    objects[i] = unmodifiableList.toArray();
                }
            }
        }
        return objects;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new IllegalStateException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new IllegalStateException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new IllegalStateException();
    }

    public String toString() {
        return unmodifiableList.toString() + modifiableList.toString();
    }
}
