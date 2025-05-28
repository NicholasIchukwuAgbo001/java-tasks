package estateApp.services;

import estateApp.dtos.requests.RegisterResidentRequest;
import estateApp.dtos.responses.RegisterResidentResponse;
import estateApp.data.model.Resident;
import estateApp.data.repository.ResidentRepository;

public class ResidentServiceImp implements ResidentServices {
    private final ResidentRepository residentRepository;

    public ResidentServiceImp(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }


    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        Resident resident = new Resident();
        resident.setName(request.getFullName());
        resident.setAddress(request.getAddress());
        resident.setPhone(request.getPhoneNumber());

        residentRepository.save(resident);

        RegisterResidentResponse response = new RegisterResidentResponse();
        response.setId(resident.getId());
        response.setFullName(resident.getName());

        return response;
    }
}