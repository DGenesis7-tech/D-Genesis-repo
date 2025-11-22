package data.repositories;

import java.util.ArrayList;
import java.util.List;

// O == Object Type
public class GenericTypesRepository<O> {
    private final List<O> objects = new ArrayList<>();

    public void save(O item) {
        objects.add(item);
    }

    public List<O> findAll() {
        return objects;
    }

    public void delete(O item) {
        objects.remove(item);
    }

    public void deleteAll() {
        objects.clear();
    }

    public long count() {
        return objects.size();
    }

    public O findByIndex(int index) {
        if (index < 0 || index >= objects.size()) return null;
        return objects.get(index);
    }
}
