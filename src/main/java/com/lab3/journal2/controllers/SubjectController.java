package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/subjects")
    public String listSubject(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
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
        subjectService.saveSubject(subject);
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
                                @ModelAttribute("subject") Subject subject,
                                Model model) {
        Subject tempSubject = subjectService.getSubjectById(id);
        tempSubject.setTitle(subject.getTitle());
        tempSubject.setHours(subject.getHours());
        subjectService.saveSubject(tempSubject);
        return "redirect:/subjects";
    }
}
