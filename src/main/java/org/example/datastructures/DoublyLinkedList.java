package org.example.datastructures;

import org.example.datastructures.abstracts.adts.QueueInterface;
import org.example.datastructures.abstracts.lists.AbstractDoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> extends AbstractDoublyLinkedList<T> {

    @Override
    public T get(int index) {
        if (index >= size || index < 0) { throw new IndexOutOfBoundsException("List size: " + size); }
        Node<T> current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean set(int index, T value) {
        if (index >= size || index < 0) { return false; }
        Node<T> current = head;
        while (index-- > 0) {
            current = current.next;
        }
        current.data = value;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) { return null; }
        Node<T> current = head;
        while (index-- > 0) {
            current = current.next;
        }
        if (null != current.prev) { current.prev.next = current.next; }
        else { head = current.next; }
        if (null != current.next) { current.next.prev = current.prev; }
        else { tail = current.prev; }
        size--;
        return current.data;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        Node<T> current = head;
        while (null != current) {
            if (current.data.equals(value)) { return index; }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return null == head ? "(empty)" : head.toString();
    }

    @Override
    public boolean enqueue(T value) {
        Node<T> node = new Node<T>(value, null, null);
        if (null == tail) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (null != head) {
            Node<T> target = head;
            head = head.next;
            tail = (head == null) ? null : tail;
            size--;
            return target.data;
        }
        return null;
    }

    @Override
    public boolean push(T value) {
        Node<T> node = new Node<T>(value, null, null);
        if (null == head) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public T pop() {
        return dequeue();
    }

    @Override
    public T peek() {
        return null == head ? null : head.data;
    }

    @Override
    public boolean reverse() {
        Node<T> temp = head;
        head = tail;
        tail = temp;
        Node<T> current = head;
        while (null != current) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.next;
        }
        return true;
    }
}
