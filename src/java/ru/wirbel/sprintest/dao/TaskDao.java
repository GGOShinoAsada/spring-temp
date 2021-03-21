/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.wirbel.sprintest.dao;
import java.util.List;

import ru.wirbel.sprintest.domain.Task;
/**
 *
 * @author roman
 */
public interface TaskDao {
    List<Task> listAllTasks();
    Task getTaskById(Integer tid);
    Task addTask(Task t);
    Task updateTask(Task t);
    boolean RemoveTask(Task t);
}
