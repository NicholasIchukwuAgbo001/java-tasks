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

    public void update(Resident resident) {
        for(int count = 0; count < residents.size(); count++){
            if(residents.get(count).getId() == resident.getId()){
                residents.set(count, resident);
                return;
            }
        }
    }
