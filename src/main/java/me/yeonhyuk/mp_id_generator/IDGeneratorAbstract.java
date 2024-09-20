package me.yeonhyuk.mp_id_generator;

public abstract class IDGeneratorAbstract<T> implements IDGenerator<T> {
    public T generateId(Object... args) {
        T id = this.getNewId(args);
        this.doAfter(id);
        return id;
    }

    protected abstract T getNewId(Object... args);

    @Override
    public void doAfter(T newId) {}
}
