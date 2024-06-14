package me.yeonhyuk.mp_id_generator;

public interface IDGenerator<T> {
    T generateId(Object... args);
    void doAfter(T newId);
}
