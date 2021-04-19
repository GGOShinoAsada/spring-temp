package com.company.controller;

import com.company.model.Contrext;
import com.company.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class TaskController extends HttpServlet {
    Contrext context = new Contrext();
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "hello";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public void Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Task> items = context.getAllTasks();
        req.setAttribute("items",items);
        getServletContext().getRequestDispatcher("/").forward(req, resp);
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public void CreateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Task item = context.getTaskById(id);
        request.setAttribute("item", item);
        getServletContext().getRequestDispatcher("/create").forward(request,response);
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void CreatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Task task = new Task(id, name, description);
        context.addTask(task);
        getServletContext().getRequestDispatcher("/").forward(req,resp);
    }
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public void Details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Task task = context.getTaskById(id);
        req.setAttribute("task",task);
        getServletContext().getRequestDispatcher("/details").forward(req,resp);
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public void UpdateGet(HttpServletResponse response, HttpServletRequest req) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Task item = context.getTaskById(id);
        req.setAttribute("item",item);
        getServletContext().getRequestDispatcher("/update").forward(req,response);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void UpdatePost(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String tmp = req.getParameter("date");
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = format.parse(tmp);
        Task task = new Task(id, name, description,date );
        getServletContext().getRequestDispatcher("/").forward(req,resp);
    }
    @RequestMapping(value = "/remove",method = RequestMethod.GET)
    public void  Remove(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        context.removeTask(id);
        getServletContext().getRequestDispatcher("/").forward(req,resp);
    }
}
