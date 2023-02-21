package com.wildcodeschool.JpaHibernateApp.controller;

import com.wildcodeschool.JpaHibernateApp.entity.Course;
import com.wildcodeschool.JpaHibernateApp.entity.Wizard;
import com.wildcodeschool.JpaHibernateApp.repository.WizardRepository;
import com.wildcodeschool.JpaHibernateApp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private WizardRepository wizardRepository;

    @GetMapping("/course/create")
    @ResponseBody
    public void getCourses() {

        Course divination = new Course("Divination");
        courseRepository.save(divination);

        Course alchemy = new Course("Alchemy");
        courseRepository.save(alchemy);

        Course herbology = new Course("Herbology");
        courseRepository.save(herbology);

    }

    @GetMapping("/courses")
    @ResponseBody
    public void addWizard(@RequestParam Long wizardId, @RequestParam(required = false) Long courseId) {

        Wizard wizard = wizardRepository.findById(wizardId).get();

        if (courseId != null && courseId <= courseRepository.count()) {
            Course course = courseRepository.findById(courseId).get();
            if (wizard.getCourses().contains(course)) {
                System.out.println("Wizard " + wizard.getFirstName() + " " + wizard.getLastName() + " is already enrolled in " + course.getTitle());
                return;
            } else {
                wizard.getCourses().add(course);
                wizardRepository.save(wizard);
            }
        } else {
            System.out.println("Course not found");
        }

        if (wizard.getCourses().isEmpty()) {
            System.out.println("Wizard " + wizard.getFirstName() + " " + wizard.getLastName() + " is not enrolled in any course");
        } else {
            System.out.println("Wizard " + wizard.getFirstName() + " " + wizard.getLastName() + " is now enrolled in ");
            for (Course choosenCourse : wizard.getCourses()) {
                System.out.println("- " + choosenCourse.getTitle());
            }
        }
    }
}
