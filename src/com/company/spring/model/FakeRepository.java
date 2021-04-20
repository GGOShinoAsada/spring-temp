package com.company.spring.model;

import java.util.ArrayList;
import java.util.List;

public class FakeRepository {
    static List<FakeModel> fakes = new ArrayList<>();
    public List<FakeModel> getAllModels(){
        fakes = new ArrayList<>();
        for (int i=0; i<10; i++){
            String data = "model number"+i;
            fakes.add(new FakeModel(i,data, "description"));
        }
        return fakes;
    }
    public FakeModel getFakeModelyById(int id){
        FakeModel fm = new FakeModel();
        for (FakeModel f: fakes) {
            if (f.getId() == id){
                fm = new FakeModel(f.getId(), f.getName(), f.getDescription());
            }
        }
        return fm;
    }
    public void updateFakeModels(FakeModel fm){
        for (FakeModel data: fakes) {
            int id = data.getId();
            if (id==fm.getId()){
                data.setName(fm.getName());
                data.setDescription(fm.getDescription());
            }
        }
    }
    public void removeFakeModel(int id){
        FakeModel fs = getFakeModelyById(id);
        if (fs!=null){
            fakes.remove(fs);
        }
    }
    public void addingFakeModel(FakeModel model){
        int count = fakes.size();
        model.setId(count+1);
        fakes.add(model);
    }
}
