package data.repositories;

import data.models.Gender;
import data.models.Owner;

import java.util.ArrayList;

public class Owners implements OwnerRepository {
    private ArrayList<Owner> owners = new ArrayList<>();

    @Override
    public Owner findById(String id) {
        for (Owner owner : owners) {
            if (owner.getId().equalsIgnoreCase(id)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Owner> findAll() {
        return new ArrayList<>(owners);
    }

    @Override
    public void deleteById(String id) {
        for (Owner owner : owners) {
            if (owner.getId().equalsIgnoreCase(id)) {
                owners.remove(owner);
                break;
            }
        }

    }

    @Override
    public void delete(Owners owner) {
       owners.remove(owner);
    }

    @Override
    public void deleteAll() {
        owners.clear();

    }

    @Override
    public long count() {
        return owners.size();
    }

    @Override
    public void updateOwner(Owner owner, String newOwnerName, String newAddress, String newEmail, long newPhoneNumber, Gender newGender) {
        if (owner != null && owners.contains(owner)) {
            owner.setName(newOwnerName);
            owner.setAddress(newAddress);
            owner.setEmail(newEmail);
            owner.setPhone(newPhoneNumber);
            owner.setGender(String.valueOf(newGender));
        }
    }
}
