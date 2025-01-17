package org.example.datastructures.interfaces;

public interface ArrayInterface<T> extends Iterable<T> {

    public boolean construct(T[] nodes);

    public int size();

    public T getElementAt(int offset);

    public boolean isEmpty();

}
