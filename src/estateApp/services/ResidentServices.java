package estateApp.services;

import estateApp.dtos.requests.LoginResidentRequest;
import estateApp.dtos.requests.RegisterResidentRequest;
import estateApp.dtos.responses.LoginResidentResponse;
import estateApp.dtos.responses.RegisterResidentResponse;

public interface ResidentServices {
    RegisterResidentResponse register(RegisterResidentRequest residentServiceRequest);

    LoginResidentResponse login(LoginResidentRequest residentServiceRequest);
}