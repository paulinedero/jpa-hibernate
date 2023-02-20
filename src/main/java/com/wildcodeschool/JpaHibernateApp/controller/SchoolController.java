package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.School;
import com.wildcodeschool.JpaHibernateApp.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/school")
    public String getWizard(Model model, @RequestParam(required = false) Long id) {

        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = schoolRepository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "school_get";
    }

    @GetMapping("/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "school_get_all";
    }

    @GetMapping("/school/create")
    public String createSchool(Model model) {
        return "school_post";
    }

    @GetMapping("/school/update")
    public String updateSchool(Model model, @RequestParam(required = true) Long id) {
        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = schoolRepository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "school_put";
    }

    @PostMapping("/school")
    public String postWizard(@ModelAttribute School school) {
        schoolRepository.save(school);
        return "redirect:/schools";
    }

    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {
        schoolRepository.deleteById(id);
        return "redirect:/schools";
    }
}
