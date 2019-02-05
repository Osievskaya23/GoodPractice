package com.list;

public class MyLinkedList<T> implements MyList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    @Override
    public T get(int index) {
        checkIndexException(index);
        return getNode(index).item;
    }

    private Node<T> getNode(int index) {
        Node<T> elem = first;
        for (int i = 0; i < index; i++) {
            elem = elem.next;
        }
        return elem;
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(T t) {
        Node<T> node;
        if (isEmpty()){
            node = new Node<>(null, t, null);
            first = node;
            last = node;
        } else {
            node = new Node<>(last, t, null);
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    private boolean isEmpty() { return size == 0; }

    @Override
    public T remove(int index) {
        checkIndexException(index);
        return delConnections(getNode(index));
    }

    private T delConnections(Node<T> node) {
        final T elemValue = node.item;
        final Node<T> next = node.next;
        final Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return elemValue;
    }

    @Override
    public int size() { return size; }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
