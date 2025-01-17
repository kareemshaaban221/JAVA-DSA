package org.example.datastructures.interfaces;

import java.util.ArrayList;

public interface ArrayInterface<T> {

    public boolean construct(ArrayList<T> nodes);

    public int size();

    public T getElementAt(int offset);

    public boolean isEmpty();

}
