package org.example.datastructures;

import org.example.datastructures.abstracts.arrays.Array;
import org.example.datastructures.abstracts.arrays.VectorInterface;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> extends Array<T> implements VectorInterface<T> {

    protected StaticArray<T> array;
    protected int capacity;
    protected int size;

    final protected int DEFAULT_CAPACITY = 8;

    public DynamicArray() {
        array = new StaticArray<T>((T[]) new Object[DEFAULT_CAPACITY]);
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public DynamicArray(T[] nodes) {
        array = new StaticArray<T>(nodes);
        capacity = size = nodes.length;
    }

    // O(1)
    @Override
    public T get(int index) {
        return array.get(index);
    }

    // Best(1) ~ Average(1) ~ O(n)
    @Override
    public boolean set(int index, T value) {
        if (! array.set(index, value)) {
            if (! expand()) { return false; }
            else {
                size++;
                return array.set(index, value);
            }
        }
        size++;
        return true;
    }

    // O(1)
    @Override
    public T remove(int index) {
        return array.remove(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array.get(index++);
            }
        };
    }

    // O(n)
    @Override
    public T shift() {
        if (size > 0) {
            T value = array.remove(0);
            for (int i = 0; i < size - 1; i++) {
                array.set(i, array.get(i + 1));
            }
            size--;
            return value;
        }
        return null;
    }

    // O(n)
    @Override
    public boolean unshift(T value) {
        if (size >= capacity) { expand(); }
        for (int i = size; i > 0; i--) {
            array.set(i, array.get(i - 1));
        }
        array.set(0, value);
        size++;
        return true;
    }

    // O(1)
    @Override
    public boolean push(T value) {
        if (size < capacity) {
            array.set(size, value);
            size++;
            return true;
        }
        return false;
    }

    // O(1)
    @Override
    public T pop() {
        if (size > 0) {
            T value = array.remove(size - 1);
            size--;
            return value;
        }
        return null;
    }

    // O(n)
    @Override
    public boolean enqueue(T value) {
        return unshift(value);
    }

    // O(1)
    @Override
    public T dequeue() {
        return pop();
    }

    // O(1)
    @Override
    public T peek() {
        return array.get(size - 1);
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    @Override
    public int capacity() {
        return capacity;
    }

    // O(n)
    @Override
    public boolean expand() {
        int newCapacity = capacity * 2;
        StaticArray<T> newArray = new StaticArray<>((T[]) new Object[newCapacity]);
        for (int i = 0; i < size; i++) {
            newArray.set(i, array.get(i));
        }
        array = newArray;
        capacity = newCapacity;
        return true;
    }

}
