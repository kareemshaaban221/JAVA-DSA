package org.example.datastructures.abstracts.lists;

import org.example.datastructures.abstracts.adts.ListInterface;

abstract public class AbstractDoublyLinkedList<T> implements ListInterface<T> {

    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    protected AbstractDoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    protected class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.data = value;
            this.prev = prev;
            this.next = next;
        }

        public boolean hasNext() { return next != null; }

        public boolean hasPrev() { return prev != null; }

        @Override
        public String toString() {
            String node = "[" + data.toString() + "]";
            return hasNext() ? node + " <-> " + next.toString() : node;
        }
    }

}
