package com.list;

public interface MyList<T> {
    T get(int index);
    boolean add(T t);
    T remove(int index);
    int size();
}
