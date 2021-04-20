package com.company.spring.controller;

import com.company.spring.model.FakeModel;
import com.company.spring.model.FakeRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeService implements IFakeRepository {
   static FakeRepository repository = new FakeRepository();
    @Override
    public List<FakeModel> getAllFakeModels() {
        List<FakeModel> models = new ArrayList<>();
        models = repository.getAllModels();
        return models;
    }

    @Override
    public FakeModel getFakeModelDetails(int id) {
        FakeModel model = new FakeModel();
        model = repository.getFakeModelyById(id);
        return model;
    }

    @Override
    public void addingFakeModel(FakeModel model) {
        repository.addingFakeModel(model);
    }

    @Override
    public void removingFakeModel(int id) {
       repository.removeFakeModel(id);
    }

    @Override
    public void updatingFakeModel(FakeModel fm) {
        repository.updateFakeModels(fm);
    }
}
