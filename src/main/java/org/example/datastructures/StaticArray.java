package org.example.datastructures;

import org.example.datastructures.interfaces.ArrayInterface;

import java.util.ArrayList;

public class StaticArray<T> implements ArrayInterface<T> {

    protected ArrayList<T> array;
    protected int size;

    public StaticArray(ArrayList<T> nodes) {
        construct(nodes);
    }

    /**
     * O(1)
     */
    @Override
    public boolean construct(ArrayList<T> nodes) {
        try {
            array = nodes;
            size = array.size();
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
        return array.get(offset);
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
