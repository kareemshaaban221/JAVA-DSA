package org.example.datastructures.abstracts.arrays;

import org.example.datastructures.abstracts.shared.Countable;

public interface ArrayInterface<T> extends Countable, Iterable<T> {

    public T get(int index);

    public boolean set(int index, T value);

    public T remove(int index);

    public int indexOf(T value);

    public boolean contains(T value);

}
