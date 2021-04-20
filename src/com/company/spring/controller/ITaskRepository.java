package com.company.spring.controller;

import com.company.spring.model.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task> getAllTasks();
    Task getTaskById(int id);
    void addingTask(Task task);
    void updatingTask(Task task);
    void removingTask(int id);
}
