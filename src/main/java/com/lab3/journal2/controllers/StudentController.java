package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping(value = "/students/{id}")
    public String showStudent(Model model, @PathVariable int id) {
        model.addAttribute("students", studentService.getStudentById(id));
        return "students";
    }

    @GetMapping(value = "/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping(value = "/students/remove/{id}")
    public String removeStudent(@PathVariable int id) {
        studentService.removeStudent(id);
        return "redirect:/students";
    }

    @GetMapping(value = "students/edit/{id}")
    public String editStudentForm(Model model, @PathVariable int id) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping(value = "/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        Student tempStudent = studentService.getStudentById(id);
        tempStudent.setId(id);
        tempStudent.setFirstName(student.getFirstName());
        tempStudent.setLastName(student.getLastName());
        tempStudent.setAge(student.getAge());
        tempStudent.setGroupName(student.getGroupName());
        studentService.updateStudent(tempStudent);
        return "redirect:/students";
    }
}
