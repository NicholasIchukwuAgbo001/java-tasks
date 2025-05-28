package estateApp.dtos.services;

import estateApp.data.model.Resident;
import estateApp.dtos.requests.RegisterResidentRequest;
import estateApp.dtos.responses.RegisterResidentResponse;
import estateApp.data.repository.ResidentRepository;
import estateApp.data.repository.Residents;
import estateApp.services.ResidentServiceImp;
import estateApp.services.ResidentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResidentServiceImpTest {

    private ResidentRepository residentRepository;
    private ResidentServices residentService;

    @BeforeEach
    void setUp() {
        residentRepository = new Residents() {
            @Override
            public Optional<Resident> findByResidentEmail(String email) {
                return Optional.empty();
            }
        };
        residentService = new ResidentServiceImp(residentRepository);
    }

    @Test
    public void testThatRegisterResidentMethodWorks() {
        RegisterResidentRequest request = new RegisterResidentRequest();
        request.setFullName("Niko");
        request.setAddress("12, epetedo street");
        request.setPhoneNumber("07058705863");

        RegisterResidentResponse response = residentService.register(request);

        assertNotNull(response);
        assertEquals("Niko", response.getFullName());
        assertEquals(1, response.getId());

        assertEquals(1, residentRepository.count());
    }
}