package com.example.sms.controller;
import com.example.sms.model.Course;
import com.example.sms.model.Teacher;
import com.example.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    SMSService teacherService;

    @GetMapping
    public String listteachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teachers";
    }

    @GetMapping("/new")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "createTeacher";
    }

    @PostMapping
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String editTeacherForm(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "updateTeacher";
    }

    @PostMapping("/{id}")
    public String updateTeacher(@PathVariable Integer id,
                                @ModelAttribute("student") Teacher teacher,
                                Model model) {
        // get student from database by id
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setId(id);
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        // save updated student object
        teacherService.saveTeacher(existingTeacher);
        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }

    @GetMapping("/{tid}/courses")
    public String viewCourses(@PathVariable("tid") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Course> courses = teacher.getCourses();
        if (courses.isEmpty()) {
            return "redirect:/teachers/" + id + "/addCourses";
        }
        model.addAttribute("remove_id", id);
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/{tid}/addCourses")
    public String addCourses(@PathVariable("tid") int id, Model model) {
        List<Course> teacherCourses = teacherService.getTeacherById(id).getCourses();
        List<Course> courses = teacherService.getAllCourse();
        List<Course> remainingCourses = new ArrayList<Course>();
        for (Course c : courses) {
            if (!teacherCourses.contains(c)) {
                remainingCourses.add(c);
            }
        }
        model.addAttribute("courses", remainingCourses);
        model.addAttribute("add_id", id);
        return "courses";
    }

    @GetMapping("/{tid}/addCourse")
    public String addCourse(@PathVariable("tid") int sid, @RequestParam("cid") int cid) {
        Teacher teacher = teacherService.getTeacherById(sid);
        Course course = teacherService.getCourseById(cid);
        teacher.addCourse(course);
        teacherService.saveTeacher(teacher);
        course.addTeacher(teacher);
        teacherService.saveCourse(course);
        return "redirect:/teachers/" + sid + "/courses";
    }

    @GetMapping("/{tid}/removeCourse")
    public String removeCourse(@PathVariable("tid") int sid, @RequestParam("cid") int cid) {
        Teacher teacher = teacherService.getTeacherById(sid);
        Course course = teacherService.getCourseById(cid);
        teacher.removeCourse(course);
        teacherService.saveTeacher(teacher);
        course.removeTeacher(teacher);
        teacherService.saveCourse(course);
        return "redirect:/teachers/" + sid + "/courses";
    }
}