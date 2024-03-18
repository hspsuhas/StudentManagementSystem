package com.example.sms.service;

import com.example.sms.model.Course;
import com.example.sms.model.Student;
import com.example.sms.model.Teacher;
import com.example.sms.repository.CourseRepository;
import com.example.sms.repository.StudentRepository;
import com.example.sms.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SMSService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id).get();
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    public void deleteCourseById(Integer id) {
        courseRepository.deleteById(id);
    }

    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
