package org.example.datastructures.abstracts.arrays;

public abstract class Array<T> implements Iterable<T> {

    abstract public int size();

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(this.getClass().getSimpleName() + "[" + size() + "]: {");
        for (T item : this) {
            string.append(" ").append(item).append(",");
        }
        string.append(" }\n");
        return string.toString();
    }
}
