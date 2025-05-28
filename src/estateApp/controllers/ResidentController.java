package estateApp.controllers;

import estateApp.dtos.requests.LoginResidentRequest;
import estateApp.dtos.requests.RegisterResidentRequest;
import estateApp.dtos.responses.LoginResidentResponse;
import estateApp.dtos.responses.RegisterResidentResponse;
import estateApp.services.ResidentServices;


public class ResidentController {

    private final ResidentServices residentServices;

    public ResidentController(ResidentServices residentServices) {
        this.residentServices = residentServices;
    }

    public RegisterResidentResponse register(RegisterResidentRequest request) {
        return residentServices.register(request);
    }

    public LoginResidentResponse login(LoginResidentRequest request) {
        return residentServices.login(request);
}
}
