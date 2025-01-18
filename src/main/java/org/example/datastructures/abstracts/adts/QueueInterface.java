package org.example.datastructures.abstracts.adts;

import org.example.datastructures.abstracts.shared.Countable;

public interface QueueInterface<T> extends Countable {

    public boolean enqueue(T value);

    public T dequeue();

    public T peek();

}
