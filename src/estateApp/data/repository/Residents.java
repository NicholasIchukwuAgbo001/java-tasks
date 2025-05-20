package estateApp.data.repository;

import estateApp.data.model.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Residents implements ResidentRepository {
    private List<Resident> residents = new ArrayList<>();
    private int currentId = 0;

    @Override
    public Resident save(Resident resident) {
        if(isNew(resident))saveNew(resident);else update(resident);
        return resident;
    }

    private void update(Resident resident) {
        for(int count = 0; count < residents.size(); count++){
            if(residents.get(count).getId() == resident.getId()){
                residents.set(count, resident);
                return;
            }
        }
    }

    private int generateId() {
        return ++currentId;
    }

    private void saveNew(Resident resident) {
        resident.setId(generateId());
        residents.add(resident);
    }

    private boolean isNew(Resident resident) {
        return resident.getId() == 0;
    }

    @Override
    public Resident findById(long id) {
        return residents.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(Resident resident) {
        for (Resident eachResident : residents) {
            if(eachResident.getId() == resident.getId()){
                residents.remove(eachResident);
                return;
            }
        }

    }

    @Override
    public List<Resident> findAll() {
        return residents;
    }


    @Override
    public long count() {
        return residents.size();
    }

    @Override
    public List<Resident> findByResidentName(String residentName) {
        return residents.stream().filter(e -> e.getName().equals(residentName)).collect(Collectors.toList());
    }

}