package data.repositories;

import data.models.Officer;
import data.models.Rank;
import java.util.List;

public interface OfficerRepository {
    Officer findById(int id);
    List<Officer> findAll();
    void deleteById(int id);
    void delete(Officer officer);
    void deleteAll();
    long count();
    void updateOfficer(Officer officer, String newName, Rank newRank);
    Officer save(Officer officer);
}
