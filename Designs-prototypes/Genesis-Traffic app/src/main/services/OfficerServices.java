package services;

import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;
import data.models.Officer;

import java.util.List;

public interface OfficerServices {
    OfficerResponse createOfficer(OfficerRequest request);
    List<OfficerResponse> getAllOfficers();
    void updateOfficer(Officer officer, OfficerRequest request);

    void updateOfficer(String id, OfficerRequest request);

    Officer findOfficerById(String id);
}
