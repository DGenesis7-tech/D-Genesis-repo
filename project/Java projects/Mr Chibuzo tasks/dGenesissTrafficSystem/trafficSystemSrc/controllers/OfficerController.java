package controllers;

import data.models.Officer;
import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;
import services.OfficerServices;

import java.util.List;

public class OfficerController {

    private OfficerServices officerServices;

    public OfficerController(OfficerServices officerServices) {
        this.officerServices = officerServices;
    }

    public OfficerResponse createOfficer(OfficerRequest request) {
        return officerServices.createOfficer(request);
    }

    public List<OfficerResponse> getAllOfficers() {
        return officerServices.getAllOfficers();
    }

    public void updateOfficer(int id, OfficerRequest request) {
        Officer officer = officerServices.findOfficerById(id);
        if (officer != null) {
            officerServices.updateOfficer(officer, request);
        } else {
            System.out.println("Officer with ID " + id + " not found.");
        }
    }
}
