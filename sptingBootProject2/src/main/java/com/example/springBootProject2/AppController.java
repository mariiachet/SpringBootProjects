package com.example.springBootProject2;

import java.util.List; // Импортируем коллекцию (класс списков)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AppController {
    @Autowired
    private CarService service;

    @RequestMapping("/")
    public String viewHomePage(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "sortOrder", required = false) String sortOrder,
                               @RequestParam(value = "sortField", required = false) String sortField) {
        List<Car> listCars = service.listAll(keyword, sortField, sortOrder);
        model.addAttribute("listCars", listCars);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("sortField", sortField);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        service.save(car);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCarForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = service.get(id);
        mav.addObject("car", car);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
