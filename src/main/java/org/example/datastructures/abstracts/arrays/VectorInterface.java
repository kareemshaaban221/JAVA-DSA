package org.example.datastructures.abstracts.arrays;

import org.example.datastructures.abstracts.adts.QueueInterface;
import org.example.datastructures.abstracts.adts.StackInterface;
import org.example.datastructures.abstracts.shared.Clearable;

public interface VectorInterface<T> extends Clearable, ArrayInterface<T>, StackInterface<T>, QueueInterface<T> {

    public int capacity();

    public boolean expand();

    public T shift();

    public boolean unshift(T value);

}
