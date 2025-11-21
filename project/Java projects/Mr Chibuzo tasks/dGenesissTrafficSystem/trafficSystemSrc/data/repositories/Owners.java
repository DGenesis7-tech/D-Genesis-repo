package data.repositories;

import data.models.Gender;
import data.models.Owner;
import java.util.List;

public class Owners extends GenericTypesRepository<Owner> implements OwnerRepository {

    @Override
    public Owner findById(int id) {
        for (Owner owner : findAll()) {
            if (owner.getId().equals(String.valueOf(id))) return owner;
        }
        return null;
    }

    @Override
    public Owner findById(String id) {
        for (Owner owner : findAll()) {
            if (owner.getId().equals(id)) return owner;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        Owner owner = findById(id);
        if (owner != null) delete(owner);
    }

    @Override
    public void deleteById(String id) {
        Owner owner = findById(id);
        if (owner != null) delete(owner);
    }

    @Override
    public void updateOwner(Owner owner, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender) {
        if (findAll().contains(owner)) {
            owner.setName(newOwnerName);
            owner.setAddress(newAddress);
            owner.setEmail(newEmail);
            owner.setPhone(newPhoneNumber);
            owner.setGender(newGender.toString());
        }
    }
}
