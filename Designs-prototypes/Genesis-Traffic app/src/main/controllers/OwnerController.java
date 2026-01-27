package controllers;

import data.models.Gender;
import data.models.Owner;
import data.repositories.Owners;

import java.util.List;

public class OwnerController {

    private Owners ownerRepo;

    public OwnerController(Owners ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    public Owner createOwner(String name, String address, String email, long phone, Gender gender) {
        Owner owner = new Owner(name, address, phone, gender, email, String.valueOf(ownerRepo.count() + 1));
        ownerRepo.save(owner);
        return owner;
    }

    public List<Owner> getAllOwners() {
        return ownerRepo.findAll();
    }

    public void updateOwner(String id, String name, String address, String email, long phone, Gender gender) {
        Owner owner = ownerRepo.findById(id);
        if (owner != null) {
            owner.setName(name);
            owner.setAddress(address);
            owner.setEmail(email);
            owner.setPhone(phone);
            owner.setGender(gender.toString());
        } else {
            System.out.println("Owner with ID " + id + " not found.");
        }
    }
}
