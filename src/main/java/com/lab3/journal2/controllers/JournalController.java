package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JournalController {
    StudentService studentService;
    SubjectService subjectService;

    public JournalController(StudentService studentService, SubjectService subjectService) {
        super();
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/journal")
    public String showJournal(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        return "journal";
    }
}
