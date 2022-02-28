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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubjectController {

    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public SubjectController(SubjectService subjectService, TeacherService teacherService) {
        super();
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/subjects")
    public String listSubject(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        Map<Integer, List<Teacher>> teacherList = new HashMap<>();
        subjects.forEach(subject -> teacherList.put(
                subject.getId(),
                teacherService.getAllTeachersBySubject(subject.getId())));
        model.addAttribute("subjects", subjects );
        model.addAttribute("teachers", teacherList);
        return "subjects";
    }

    @GetMapping(value = "/subjects/new")
    public String createSubjectForm(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";
    }

    @PostMapping("/subjects")
    public String saveStudent(@ModelAttribute("subject") Subject subject) {
        subjectService.createSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping(value = "/subjects/remove/{id}")
    public String removeSubject(@PathVariable int id) {
        subjectService.removeSubject(id);
        return "redirect:/subjects";
    }

    @GetMapping(value = "subjects/edit/{id}")
    public String editSubjectForm(Model model, @PathVariable int id) {
        model.addAttribute("subject", subjectService.getSubjectById(id));
        return "edit_subject";
    }

    @PostMapping(value = "/subjects/{id}")
    public String updateSubject(@PathVariable int id,
                                @ModelAttribute("subject") Subject subject) {
        Subject tempSubject = subjectService.getSubjectById(id);
        tempSubject.setTitle(subject.getTitle());
        tempSubject.setHours(subject.getHours());
        subjectService.updateSubject(tempSubject);
        return "redirect:/subjects";
    }
}
