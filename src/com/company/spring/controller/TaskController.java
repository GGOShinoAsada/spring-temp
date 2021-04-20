package com.company.spring.controller;

import com.company.spring.controller.Service;
import com.company.spring.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TaskController {
    @Autowired
    Service service;
    @RequestMapping("/")
    public ModelAndView index() {
        List<Task> listtasks = service.getAllTasks();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listTasks", listtasks);
        return mav;
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addingNewTaskGet(){
        return "new_task";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addingNewTaskPost(@RequestParam String name, @RequestParam String description){
        Task task = new Task(name,description);
        service.addingTask(task);
        return "redirect:/";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateTaskGet(@RequestPart int taskid, Model model){
        Task task = service.getTaskById(taskid);
        model.addAttribute("taskitem",task);
        return "task_edit";
    }
    @RequestMapping(value = "/update/",method = RequestMethod.POST)
    public String updateTaskPost(@RequestParam String name, @RequestParam String description, @RequestParam java.util.Date dat){
        Task task = new Task(name,description,dat);
        service.updatingTask(task);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{taskid}",method = RequestMethod.GET)
    public String removeTask(@RequestPart int taskid){
        service.removingTask(taskid);
        return "redirect:/";
    }
    /*public String newCustomerForm(Map<String, Object> model) {
        Task task = new Task();
        model.put("task", task);
        return "new_task";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task) {
        service.save(task);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_task");
        Task task = service.get(id);
        task.setDate( new java.util.Date());
        mav.addObject("task", task);
        return mav;
    }
    @RequestMapping("/delete")
    public String deleteTaskForm(@RequestParam int id) {
        service.delete(id);
        return "redirect:/";
    }*/

}
