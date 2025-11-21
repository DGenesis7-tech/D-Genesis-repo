package services;

import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;
import data.models.Officer;
import data.repositories.Officers;
import utils.Mapper;

import java.util.List;

public class OfficerServicesImpl implements OfficerServices {

    private Officers officerRepo;

    public OfficerServicesImpl(Officers officerRepo) {
        this.officerRepo = officerRepo;
    }

    public OfficerServicesImpl() {

    }

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
        officerRepo.updateOfficer(officer, request.getName(), request.getRank());
    }

    @Override
    public Officer findOfficerById(int id) {
        return officerRepo.findById(id);
    }
}
