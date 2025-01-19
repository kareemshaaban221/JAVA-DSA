package org.example.datastructures.abstracts.adts;

import org.example.datastructures.abstracts.arrays.ArrayInterface;

public interface ListInterface<T> extends ArrayInterface<T>, StackInterface<T>, QueueInterface<T> {

    public boolean reverse();

}
