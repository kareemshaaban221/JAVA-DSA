package org.example.datastructures.abstracts.adts;

import org.example.datastructures.abstracts.shared.Countable;

public interface StackInterface<T> extends Countable {

    public boolean push(T value);

    public T pop();

    public T peek();

}
