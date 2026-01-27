package data.repositories;

import data.models.Officer;
import data.models.Rank;
import java.util.List;

public interface OfficerRepository {
    Officer findById(String id);
    List<Officer> findAll();
    long count();
    void save(Officer officer);
}
