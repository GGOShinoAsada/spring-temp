package com.company.spring.controller;

import com.company.spring.model.Context;
import com.company.spring.model.FakeModel;
import com.company.spring.model.FakeRepository;
import com.company.spring.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Service implements ITaskRepository {
    static FakeRepository repository = new FakeRepository();
    static Context context = new Context();
    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = context.getAllTasks();
       return  tasks;
    }

    @Override
    public Task getTaskById(int id) {
        Task task = new Task();
        task = context.getTaskById(id);
        return task;
    }

    @Override
    public void addingTask(Task task) {
        context.insertTask(task);
    }

    @Override
    public void updatingTask(Task task) {
        context.updateTask(task);
    }

    @Override
    public void removingTask(int id) {
        context.removeTask(id);
    }
}
