package org.example.controller;

import org.example.model.RailwayCarriage;
import org.example.service.RailwayCarriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/railwayCarriage")
public class RailwayCarriageController {

    @Autowired
    private RailwayCarriageService railwayCarriageService;

    @GetMapping
    @ResponseBody
    public List<RailwayCarriage> getAll() {
        return railwayCarriageService.findAll();
    }

    @PostMapping("/create")
    public void create(@ModelAttribute RailwayCarriage railwayCarriage) {
        railwayCarriageService.save(railwayCarriage);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<RailwayCarriage> getById(Model model, @PathVariable int id) {
        var railwayCarriageOptional = railwayCarriageService.findById(id);
        if (railwayCarriageOptional.isEmpty()) {
            model.addAttribute("error", "Вагон не найден");
        }
        model.addAttribute(railwayCarriageOptional.get());
        return null;
    }

    @PostMapping("/update")
    public void update(@ModelAttribute RailwayCarriage railwayCarriage) {
        railwayCarriageService.update(railwayCarriage);
    }


    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        railwayCarriageService.deleteById(id);
    }
}
