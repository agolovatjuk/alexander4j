package ru.job4j.generic;

public class RoleStore<T extends Role> implements Store<T> {
    /**
     * RoleStore<T extends Role> extends AbstractStore<T> implements Store<T> -- doesn't protect Role store from add
     * User elements
     */

    private LocalStore<T> store;

    private class LocalStore<T> extends AbstractStore {
        LocalStore(int capacity) {
            super(capacity);
        }
    }

    public RoleStore(int capacity) {
        store = new LocalStore<>(capacity);
    }

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public T findById(String id) {
        return (T) store.findById(id);
    }
}
