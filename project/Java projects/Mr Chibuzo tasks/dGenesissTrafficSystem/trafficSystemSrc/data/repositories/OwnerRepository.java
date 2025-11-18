package data.repositories;

import data.models.Gender;
import data.models.Owner;

import java.util.ArrayList;

public interface OwnerRepository {
    Owner findById(int id);

    Owner findById(String id);

    ArrayList<Owner> findAll();
    void deleteById(int id);

    void deleteById(String id);

    void delete(Owners owners);
    void deleteAll();
    long count();
    void updateOwner(Owner owner, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender);
}


