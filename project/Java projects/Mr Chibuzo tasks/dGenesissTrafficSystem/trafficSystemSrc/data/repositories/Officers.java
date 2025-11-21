package data.repositories;

import data.models.Officer;
import data.models.Rank;

public class Officers extends GenericTypesRepository<Officer> implements OfficerRepository {

    @Override
    public Officer findById(int id) {
        for (Officer officer : findAll()) {
            if (officer.getId() == id) return officer;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        Officer officer = findById(id);
        if (officer != null) {
            delete(officer);
        }
    }

    @Override
    public void updateOfficer(Officer officer, String newName, Rank newRank) {
        if (findAll().contains(officer)) {
            officer.setName(newName);
            officer.setRank(newRank);
        }
    }
}
