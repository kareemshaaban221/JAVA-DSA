package org.example.datastructures;

import org.example.datastructures.interfaces.ArrayInterface;

public class StaticArray<T> implements ArrayInterface<T> {

    protected T[] array;
    protected int size;

    public StaticArray(T[] nodes) {
        construct(nodes);
    }

    /**
     * O(1)
     */
    @Override
    public boolean construct(T[] nodes) {
        try {
            array = nodes;
            size = array.length;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * O(1)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * O(1)
     */
    @Override
    public T getElementAt(int offset) {
        return array[offset];
    }

    /**
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("StaticArray[" + size + "]: {");
        for (T item : array) {
            string.append(" ").append(item).append(",");
        }
        string.append(" }\n");
        return string.toString();
    }
}
