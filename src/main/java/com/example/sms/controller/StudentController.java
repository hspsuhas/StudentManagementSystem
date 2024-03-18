package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.model.Student;
import com.example.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    SMSService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "createStudent";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "updateStudent";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setRegNo(student.getRegNo());
        // save updated student object
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/{id}/courses")
    public String viewCourses(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Course> courses = student.getCourses();
        if (courses.isEmpty()) {
            return "redirect:/students/" + id + "/addCourses";
        }
        model.addAttribute("remove_id", id);
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/{id}/addCourses")
    public String addCourses(@PathVariable("id") int id, Model model) {
        List<Course> studentCourses = studentService.getStudentById(id).getCourses();
        List<Course> courses = studentService.getAllCourse();
        List<Course> remainingCourses = new ArrayList<Course>();
        for (Course c : courses) {
            if (!studentCourses.contains(c)) {
                remainingCourses.add(c);
            }
        }
        model.addAttribute("courses", remainingCourses);
        model.addAttribute("add_id", id);
        return "courses";
    }

    @GetMapping("/{sid}/addCourse")
    public String addCourse(@PathVariable("sid") int sid, @RequestParam("cid") int cid) {
        Student student = studentService.getStudentById(sid);
        Course course = studentService.getCourseById(cid);
        student.addCourse(course);
        studentService.saveStudent(student);
        course.addStudent(student);
        studentService.saveCourse(course);
        return "redirect:/students/" + sid + "/courses";
    }

    @GetMapping("/{sid}/removeCourse")
    public String removeCourse(@PathVariable("sid") int sid, @RequestParam("cid") int cid) {
        Student student = studentService.getStudentById(sid);
        Course course = studentService.getCourseById(cid);
        student.removeCourse(course);
        studentService.saveStudent(student);
        course.removeStudent(student);
        studentService.saveCourse(course);
        return "redirect:/students/" + sid + "/courses";
    }
}