package com.example.springbootproject4;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private MachineService service;

    @RequestMapping("/")
    public String viewHomePage(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "sortOrder", required = false) String sortOrder,
                               @RequestParam(value = "sortField", required = false) String sortField) {
        List<Machine> listMachines = service.listAll(keyword, sortField, sortOrder);
        model.addAttribute("listMachines", listMachines);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("sortField", sortField);

        int machineCount = listMachines.size();
        model.addAttribute("machineCount", machineCount);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewMachineForm(Model model) {
        Machine machine = new Machine();
        model.addAttribute("machine", machine);
        return "new_machine";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMachine(@ModelAttribute("machine") Machine machine) {
        service.save(machine);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditMachineForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_machine");
        Machine machine = service.get(id);
        mav.addObject("machine", machine);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMachine(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
