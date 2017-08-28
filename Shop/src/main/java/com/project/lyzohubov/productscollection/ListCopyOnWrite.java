package com.project.lyzohubov.productscollection;

import java.util.*;

public class ListCopyOnWrite<E> implements List<E> {

    private Object[] objects = new Object[10];
    private int size = 0;

    @Override
    public boolean add(E object) {
        if (size < objects.length) {
            objects[size++] = object;
        } else {
            enlargeCapacity();
            objects[size++] = object;
        }

        return true;
    }

    private void enlargeCapacity() {
        int oldCapacity = objects.length;
        int newCapacity = oldCapacity + oldCapacity / 2;
        objects = Arrays.copyOf(objects, newCapacity);
    }

    public Iterator<E> iterator() {
        return new ListCopyOnWriteIterator(size());
    }

    private class ListCopyOnWriteIterator implements Iterator<E> {
        private int cursor;
        private Object[] snapshot;
        int newSize;

        ListCopyOnWriteIterator(int size) {
            newSize = size;
        }

        @Override
        public boolean hasNext() {
            snapshot = ListCopyOnWrite.this.objects;
            return cursor < newSize;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) snapshot[cursor++];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    @Override
    public <T> T[] toArray(T[] object) {
        if (object.length < size)
            return (T[]) Arrays.copyOf(objects, size, object.getClass());
        System.arraycopy(objects, 0, object, 0, size);
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }


    @Override
    public boolean remove(Object object) {
        if (object == null) {
            for (int index = 0; index < size; index++)
                if (objects[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (object.equals(objects[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(objects, index + 1, objects, index,
                    numMoved);
        objects[--size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Object[] newArray = collection.toArray();
        int numNew = newArray.length;
        enlargeCapacity();
        System.arraycopy(newArray, 0, objects, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        Object[] newArray = collection.toArray();
        int numNew = newArray.length;
        enlargeCapacity();
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(objects, index, objects, index + numNew,
                    numMoved);

        System.arraycopy(newArray, 0, objects, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        objects = null;
        size = 0;
        return true;
    }


    @Override
    public boolean retainAll(Collection collection) {
        if (!isValidList(collection)) {
            return false;
        }

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (!collection.contains(objects[i])) {
                remove(i);
                i--;
                flag = true;
            }
        }
        return flag;
    }

    private boolean isValidList(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection.isEmpty()) {
            throw new NullPointerException();
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
            size = 0;
        }
    }

    @Override
    public E get(int index) {
        checkIfIndexInRange(index);
        return elementData(index);
    }

    private void checkIfIndexInRange(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private E elementData(int index) {
        return (E) objects[index];
    }

    @Override
    public E set(int index, E element) {
        checkIfIndexInRange(index);
        E oldValue = (E) objects[index];
        objects[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkIfIndexInRange(index);
        objects[index] = element;
        size++;
    }


    @Override
    public E remove(int index) {
        E oldValue;
        checkIfIndexInRange(index);
        oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(objects, index + 1, objects, index, numMoved);
            //clear to let GC do its work
        }
        objects[--size] = null;

        return oldValue;
    }

    @Override
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++)
                if (objects[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (object.equals(objects[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--)
                if (objects[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(objects[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(objects[i].toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
