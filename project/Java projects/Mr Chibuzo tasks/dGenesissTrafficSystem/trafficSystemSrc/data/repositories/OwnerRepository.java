package data.repositories;

import data.models.Officer;
import data.models.Owner;
import data.models.Gender;
import java.util.List;

public interface OwnerRepository {
    Owner findById(int id);
    Owner findById(String id);
    List<Owner> findAll();
    void deleteById(int id);
    void deleteById(String id);
    void delete(Owner owner);
    void deleteAll();
    long count();
    void updateOwner(Owner owner, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender);
    Officer save(Owner owner);
}
