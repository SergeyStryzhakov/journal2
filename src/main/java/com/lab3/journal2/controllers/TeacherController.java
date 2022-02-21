package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.entities.Teacher;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    private TeacherService teacherService;
    private SubjectService subjectService;

    public TeacherController(TeacherService teacherService, SubjectService subjectService) {
        super();
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    @GetMapping(value = "/teachers/new")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("subject", subject);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping(value = "/teachers/{id}")
    public String removeTeacher(@PathVariable int id) {
        teacherService.removeTeacher(id);
        return "redirect:/teachers";
    }

    @GetMapping(value = "teachers/edit/{id}")
    public String editTeacherForm(Model model, @PathVariable int id) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }

    @PostMapping(value = "/teachers/{id}")
    public String updateTeacher(@PathVariable int id,
                                @ModelAttribute("teacher") Teacher teacher,
                                Model model) {
        Teacher tempTeacher = teacherService.getTeacherById(id);
        tempTeacher.setId(id);
        tempTeacher.setFirstName(teacher.getFirstName());
        tempTeacher.setLastName(teacher.getLastName());
        tempTeacher.setSalary(teacher.getSalary());
        tempTeacher.setSubject(teacher.getSubject());
        teacherService.updateTeacher(tempTeacher);
        return "redirect:/teachers";
    }
}
