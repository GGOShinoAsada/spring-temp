package com.company.spring.controller;

import com.company.spring.model.FakeModel;

import java.util.List;

public interface IFakeRepository {
    public List<FakeModel> getAllFakeModels();
    public FakeModel getFakeModelDetails(int id);
    public void addingFakeModel(FakeModel model);
    public void removingFakeModel(int id);
    public void updatingFakeModel(FakeModel fm);
}
