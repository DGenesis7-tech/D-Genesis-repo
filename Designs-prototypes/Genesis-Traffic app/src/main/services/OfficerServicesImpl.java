package services;

import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;
import data.models.Officer;
import data.repositories.Officers;
import utils.Mapper;

import java.util.List;

public class OfficerServicesImpl implements OfficerServices {

    private Officers officerRepo;

    public OfficerServicesImpl(Officers officerRepo) { this.officerRepo = officerRepo; }
    public OfficerServicesImpl() { this.officerRepo = new Officers(); }

    @Override
    public OfficerResponse createOfficer(OfficerRequest request) {
        Officer officer = Mapper.mapRequestToOfficer(request);
        officerRepo.save(officer);
        return Mapper.mapOfficerToResponse(officer);
    }

    @Override
    public List<OfficerResponse> getAllOfficers() {
        return Mapper.mapOfficerListToResponseList(officerRepo.findAll());
    }

    @Override
    public void updateOfficer(Officer officer, OfficerRequest request) {

    }

    @Override
    public void updateOfficer(String id, OfficerRequest request) {

    }


    @Override
    public Officer findOfficerById(String id) {
        return officerRepo.findById(id);
    }
}
