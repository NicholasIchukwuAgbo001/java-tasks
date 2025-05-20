package estateApp.data.repository;

import estateApp.data.model.Resident;

import java.util.List;

public interface ResidentRepository {

    Resident save(Resident resident);

    Resident findById(long id);

    void delete(Resident resident);

    List<Resident> findAll();

    long count();

    List<Resident> findByResidentName(String residentName);
}
