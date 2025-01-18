package org.example.datastructures;

import org.example.datastructures.abstracts.arrays.Array;
import org.example.datastructures.abstracts.arrays.ArrayInterface;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class StaticArray<T> extends Array<T> implements ArrayInterface<T> {

    protected T[] array;
    protected int size;

    public StaticArray(int size) {
        array = (T[]) new Object[size];
        this.size = size;
    }

    public StaticArray(T[] nodes) {
        array = nodes;
        size = array.length;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public T get(int index) {
        if (index >= size) { throw new IndexOutOfBoundsException("Array size: " + size); }
        return array[index];
    }

    // O(1)
    @Override
    public boolean set(int index, T value) {
        try {
            array[index] = value;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    // O(1)
    @Override
    public T remove(int index) {
        T value = get(index);
        return set(index, null) ? value : null;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return size <= 0;
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
                return array[index++];
            }
        };
    }
}
