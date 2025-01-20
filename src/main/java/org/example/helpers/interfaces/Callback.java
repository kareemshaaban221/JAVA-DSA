package org.example.helpers.interfaces;

public interface Callback<T> {
    public void run(T object, boolean newLevel);
}
