package com.github.BranKein.mp_id_generator;

public interface IDGenerator<T> {
    T generateId(Object... args);
    void doAfter(T newId);
}
