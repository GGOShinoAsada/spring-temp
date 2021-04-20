package com.company.spring.controller;

import com.company.spring.model.FakeModel;
import com.company.spring.model.FakeRepository;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class FakeModelController {
    @Autowired
    static FakeService repository = new FakeService();
    @RequestMapping(value = "/fakemodel/", method = RequestMethod.GET)

    public List<FakeModel> getAllFakeModels(Model model){
        var items = repository.getAllFakeModels();
        model.addAttribute("fakemodels",items);
        return items;
    }
    @RequestMapping(value = "fakemodel/details/{fmid}", method=RequestMethod.GET)
    public String getFakeRepositoryById(@RequestPart int fmid, Model model){
        FakeModel m = repository.getFakeModelDetails(fmid);
        model.addAttribute("item",m);
        return "model_details";
    }
    @RequestMapping(value = "/fakemodels/new", method = RequestMethod.GET)
    public String addFakeModelGet(){
        return "newmodel";
    }
    @RequestMapping(value = "/fakemodel/new", method = RequestMethod.POST)
    public String addFakeModelPost(@RequestParam String name, @RequestParam String descr){
        FakeModel model = new FakeModel(name, descr);
        repository.addingFakeModel(model);
        return "redirect:/fakemodel/";
    }
    @RequestMapping(value = "fakemodel/edit/{fmid}", method = RequestMethod.GET)
    public String updateFakeModelGet(@PathVariable int fmid, Model model){
        FakeModel fm = repository.getFakeModelDetails(fmid);
        model.addAttribute("model",fm);
        return "edit_model";
    }
    @RequestMapping(value = "/fakemodel/edit", method = RequestMethod.POST)
    public String updateFakeModelPost(@RequestParam String name, @RequestParam String description, Model model)  {
        FakeModel tmp = new FakeModel(name, description);
        repository.updatingFakeModel(tmp);
        return "redirect:/fakemodel/";
    }
    @RequestMapping(value = "/fakemodel/delete/{fmid}", method = RequestMethod.GET)
    public String removeFakeModel( @PathVariable int fmid){
        repository.removingFakeModel(fmid);
        return "redirect:/fakemodel/";
    }
}
