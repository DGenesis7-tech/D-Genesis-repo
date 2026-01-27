package data.repositories;

import data.models.Officer;
import data.models.Rank;

public class Officers extends GenericTypesRepository<Officer> implements OfficerRepository {

    @Override
    public Officer findById(String id) {
        for (Officer officer : findAll()) {
            if (officer.getId().equals(id)) return officer;
        }
        return null;
    }

    @Override
    public void updateOfficer(String id, String newName, Rank newRank) {
        Officer officer = findById(id);
        if (officer != null) {
            officer.setName(newName);
            officer.setRank(newRank);
        }
    }
}
