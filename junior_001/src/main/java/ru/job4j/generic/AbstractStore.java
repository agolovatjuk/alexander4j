package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> base;

    public AbstractStore(int capacity) {
        base = new SimpleArray<T>(capacity);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public void add(Base model) {
        base.add((T) model);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public boolean replace(String id, Base model) {
        int cnt = 0;
        boolean result = false;
        for (T item: base) {
            if (id.equals(item.getId())) {
                base.set(cnt, (T) model);
                result = true;
                break;
            }
            cnt++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (T item: base) {
            if (id.equals(item.getId())) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T item: base) {
            if (id.equals(item.getId())) {
                result = item;
            }
        }
        return result;
    }
}
