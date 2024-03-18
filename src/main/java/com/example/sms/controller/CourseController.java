package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.model.Student;
import com.example.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    SMSService courseService;

    @GetMapping("")
    public String findAll(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/new")
    public String add(Model model) {
        Course theCourse = new Course();
        model.addAttribute("theCourse", theCourse);
        return "createCourse";
    }

    @GetMapping("/update/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "updateCourse";
    }

    @PostMapping("/{id}")
    public String updateCourse(@PathVariable Integer id,
                               @ModelAttribute("course") Student student,
                               Model model) {
        // get student from database by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setName(student.getName());
        // save updated student object
        courseService.saveCourse(existingCourse);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("theCourse") Course theCourse) {
        courseService.saveCourse(theCourse);
        return "redirect:/courses";
    }
}
