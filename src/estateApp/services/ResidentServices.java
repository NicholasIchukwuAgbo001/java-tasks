package estateApp.services;

import estateApp.dtos.requests.RegisterResidentRequest;
import estateApp.dtos.responses.RegisterResidentResponse;

public interface ResidentServices {
    RegisterResidentResponse register(RegisterResidentRequest residentServiceRequest);
}