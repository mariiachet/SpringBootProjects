package com.example.springbootproject3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private SeanceService service;


    @RequestMapping("/")
    public String viewHomePage(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "sortOrder", required = false) String sortOrder,
                               @RequestParam(value = "sortField", required = false) String sortField) {
        List<Seance> listSeances = service.listAll(keyword, sortField, sortOrder);
        model.addAttribute("listSeances", listSeances);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("sortField", sortField);


        int seanceCount = listSeances.size();
        model.addAttribute("seanceCount", seanceCount);

        return "index";
    }


    @RequestMapping("/new")
    public String showNewSeanceForm(Model model) {
        Seance seance = new Seance();
        model.addAttribute("seance", seance);
        return "new_seance";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSeance(@ModelAttribute("seance") Seance seance) {
        service.save(seance);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditSeanceForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_seance");
        Seance seance = service.get(id);
        mav.addObject("seance", seance);
        return mav;
    }


    @RequestMapping("/delete/{id}")
    public String deleteSeance(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
