package data.repositories;

import data.models.Officer;

import java.util.ArrayList;
import java.util.List;

// O == Object Type
public class GenericTypesRepository<O> {
    private List<O> items = new ArrayList<>();

    public Officer save(O item) {
        items.add(item);
        return null;
    }

    public List<O> findAll() {
        return new ArrayList<>(items);
    }

    public void delete(O item) {
        items.remove(item);
    }

    public void deleteAll() {
        items.clear();
    }

    public long count() {
        return items.size();
    }

    public O findByIndex(int index) {
        if (index < 0 || index >= items.size()) return null;
        return items.get(index);
    }
}
