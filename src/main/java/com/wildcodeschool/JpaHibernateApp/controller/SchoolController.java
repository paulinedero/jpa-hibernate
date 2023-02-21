package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.School;
import com.wildcodeschool.JpaHibernateApp.entity.Wizard;
import com.wildcodeschool.JpaHibernateApp.repository.SchoolRepository;
import com.wildcodeschool.JpaHibernateApp.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private WizardRepository wizardRepository;

    @GetMapping("/school")
    public String getSchool(Model model, @RequestParam(required = false) Long id) {

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

    @GetMapping("/registration")
    public String getWizardsPerSchool(Model model, @RequestParam(required = true) Long id) {

        Optional<School> optionalSchool = schoolRepository.findById(id);
        List<Wizard> allWizards = wizardRepository.findAll();

        if (optionalSchool.isPresent()) {

            School school = optionalSchool.get();
            List<Wizard> wizardsRegistered = school.getWizards();

            for (Wizard wizard : wizardsRegistered) {
                    allWizards.remove(wizard);
            }

            model.addAttribute("school", school);
            model.addAttribute("wizards", wizardsRegistered);
            model.addAttribute("wizardsNotRegistered", allWizards);

        }
        return "school_get_wizards";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String schoolId, @RequestParam String wizardId) {
        Optional<Wizard> optionalWizard = wizardRepository.findById(Long.parseLong(wizardId));
        if (optionalWizard.isPresent()) {
            Wizard wizard = optionalWizard.get();
            Long schoolIdLong = Long.parseLong(schoolId);
            School school = schoolRepository.findById(schoolIdLong).get();
            wizard.setSchool(school);
            wizardRepository.save(wizard);
        }
        return "redirect:/registration?id=" + schoolId;
    }

}
