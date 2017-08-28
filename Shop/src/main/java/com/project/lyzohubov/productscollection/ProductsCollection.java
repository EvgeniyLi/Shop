package com.project.lyzohubov.productscollection;

import java.util.*;
import java.util.function.Predicate;

public class ProductsCollection<E> implements List<E> {

    private Predicate<E> predicate = null;
    private Object[] objects = new Object[10];
    private int size = 0;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Creates ProductsCollection an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public ProductsCollection(int initialCapacity) {
        if (initialCapacity > 0) {
            objects = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            objects = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * Default constructor
     */
    public ProductsCollection() {
    }

    /**
     * Returns predicate of productsCollection
     */
    public Predicate<E> getPredicate() {
        return predicate;
    }

    /**
     * @return size in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Setting predicate of productsCollection
     */
    public void setPredicate(Predicate<E> predicate) {
        this.predicate = predicate;
    }

    /**
     * @return if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns if this list contains the specified element
     *
     * @param o element whose presence in this list is to be tested
     * @return if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorGoods();
    }


    public class IteratorGoods implements Iterator<E> {
        private E nextObject;
        private boolean hasNext;
        int cursor;       // index of next
        int lastRet = -1; // index of last

        public IteratorGoods() {
            if (predicate == null) {
                predicate = new Predicate<E>() {
                    @Override
                    public boolean test(E e) {
                        return true;
                    }
                };
            }
        }

        @Override
        public boolean hasNext() {
            Object[] newElementData = ProductsCollection.this.objects;
            while (cursor != size) {
                int i = cursor;
                if (i >= size) {
                    throw new NoSuchElementException();
                }
                cursor = i + 1;
                lastRet = i;

                E object = (E) newElementData[lastRet];
                if (predicate.test(object)) {
                    nextObject = object;
                    hasNext = true;
                    return true;
                }
            }
            return false;
        }

        @Override
        public E next() {
            if (!hasNext) {
                throw new NoSuchElementException();
            }
            hasNext = false;
            return nextObject;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     */
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

    /**
     * Appends the specified element to the end of this list.
     *
     * @param object element to be appended to this list
     * @return true (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(Object object) {
        if (size < objects.length) {
            objects[size++] = object;
        } else {
            enlargeCapacity();
            objects[size++] = object;
        }

        return true;
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     */
    private void enlargeCapacity() {
        int oldCapacity = objects.length;
        int newCapacity = oldCapacity + oldCapacity / 2;
        objects = Arrays.copyOf(objects, newCapacity);
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * i such that
     */
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

    /**
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(objects, index + 1, objects, index,
                    numMoved);
        objects[--size] = null; // clear to let GC do its work
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.  In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     */
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

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
            size = 0;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) {
        checkIfIndexInRange(index);
        return elementData(index);
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     */
    @Override
    public E set(int index, Object element) {
        checkIfIndexInRange(index);
        E oldValue = (E) objects[index];
        objects[index] = element;
        return oldValue;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @return true (as specified by {@link Collection#add})
     */
    @Override
    public void add(int index, Object element) {
        checkIfIndexInRange(index);
        objects[index] = element;
        size++;
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.
     */

    private void checkIfIndexInRange(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private E elementData(int index) {
        return (E) objects[index];
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     * <p>
     * param index the index of the element to be removed
     *
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        E oldValue = null;
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

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (objects[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(objects[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
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

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     */
    @Override
    public boolean removeAll(Collection collection) {
        objects = null;
        System.out.println("All objects removed ");
        size = 0;
        return true;
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
        for (int i = 0; i < size; i++) {
            stringBuilder.append(objects[i].toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}




