package com.list;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public MyArrayList () {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T get(int index) {
        checkIndexException(index);
        return (T)elementData[index];
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean add(T t) {
        if (size == elementData.length) {
            increaseCapacity();
        }
        elementData[size++] = t;
        return true;
    }

    private void increaseCapacity() {
        elementData = Arrays.copyOf(elementData, elementData.length*2);
    }

    @Override
    public T remove(int index) {
        checkIndexException(index);
        T elem = (T)elementData[index];
        elementData[index] = null;
        int currentIndex = index;
        int nextIndex = index + 1;
        while (currentIndex < size) {
            elementData[currentIndex] = elementData[nextIndex];
            elementData[nextIndex] = null;
            currentIndex++;
            nextIndex++;
        }
        size--;
        return elem;
    }

    @Override
    public int size() { return size; }
}
