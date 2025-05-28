package estateApp.data.repository;

import estateApp.data.model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResidentsTest {
    private Residents residents;

    @BeforeEach
    void setUp() {
        residents = new Residents() {
            @Override
            public Optional<Resident> findByResidentEmail(String email) {
                return Optional.empty();
            }
        };
    }

    @Test
    public void testSaveResident() {
        Resident resident = new Resident();
        residents.save(resident);
        assertEquals(1, residents.count());
    }

    @Test
    public void testUpdateResident() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        assertEquals(1, residents.count());
        Resident residentTwo = new Resident();
        residentTwo.setId(residentOne.getId());
        residentTwo.setName("Niko");
        residents.save(residentTwo);
        assertEquals(1, residents.count());
        assertEquals("Niko", residentTwo.getName());
        assertEquals(residentOne.getId(), residentTwo.getId());

    }

    @Test
    public void testDeleteResident() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        assertEquals(1, residents.count());
        residents.delete(residentOne);
        assertEquals(0, residents.count());
    }
    @Test
    public void testFindAllResident() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        Resident residentTwo = new Resident();
        residents.save(residentTwo);
        List<Resident> allResidents = residents.findAll();
        assertEquals(2, allResidents.size());
    }

    @Test
    public void testFindResidentById() {
        Resident residentOne = new Resident();
        Resident actual = residents.save(residentOne);
        Resident expected = residents.findById(residentOne.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindResidentByName() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        residentOne.setName("Niko");
        Resident residentTwo = new Resident();
        residents.save(residentTwo);
        residentTwo.setName("John Doe");
        Resident residentThree = new Resident();
        residents.save(residentThree);
        residentThree.setName("Mary Smith");
        List<Resident> allResidents = residents.findByResidentName("John Doe");
        assertEquals(1, allResidents.size());
    }

}