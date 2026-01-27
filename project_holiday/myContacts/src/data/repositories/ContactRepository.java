package repositories;

import java.util.List;

public interface ContactRepository {

    void save(models.Contact contact);

    List<models.Contact> findAll();

    models.Contact findById(int id);

    void delete(models.Contact contact);
}
