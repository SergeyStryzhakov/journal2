package com.lab3.journal2.controllers;

import com.lab3.journal2.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
