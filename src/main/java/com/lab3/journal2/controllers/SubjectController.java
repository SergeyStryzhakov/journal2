package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.entities.Teacher;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/subjects")
public class SubjectController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public SubjectController(SubjectService subjectService, TeacherService teacherService) {
        super();
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    /**
     * Get list of all subjects from DB
     *
     * @param model model
     * @return list all subjects
     */
    @GetMapping()
    public String listSubject(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        //Map with subject id and same teachers, who can teach this subject
        Map<Integer, List<Teacher>> teacherList = new HashMap<>();
        subjects.forEach(subject -> teacherList.put(
                subject.getId(),
                teacherService.getAllTeachersBySubject(subject.getId())));
        model.addAttribute("subjects", subjects);
        model.addAttribute("teachers", teacherList);
        return "subjects";
    }

    /**
     * Create form for making new subject
     *
     * @param model model
     * @return create form html
     */
    @GetMapping(value = "/new")
    public String createSubjectForm(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";
    }

    /**
     * Add new subject in DB
     *
     * @param subject subject entity
     * @return list all subjects
     */
    @PostMapping()
    public String saveStudent(@ModelAttribute("subject") Subject subject) {
        subjectService.createSubject(subject);
        LOGGER.info("New subject is created: " + subject.toString());
        return "redirect:/subjects";
    }

    /**
     * Remove subject by id
     *
     * @param id subject id
     * @return list all subjects
     */
    @GetMapping(value = "/remove/{id}")
    public String removeSubject(@PathVariable int id) {
        subjectService.removeSubject(id);
        LOGGER.info("Subject with id " + id + " is removed successfully.");
        return "redirect:/subjects";
    }

    /**
     * Create form for editing subject
     *
     * @param model model
     * @param id    subject id
     * @return Edit subject form
     */
    @GetMapping(value = "/edit/{id}")
    public String editSubjectForm(Model model, @PathVariable int id) {
        model.addAttribute("subject", subjectService.getSubjectById(id));
        return "edit_subject";
    }

    /**
     * Update subject in DB by id
     *
     * @param id      subject id
     * @param subject entity
     * @return list all subject
     */
    @PostMapping(value = "/{id}")
    public String updateSubject(@PathVariable int id,
                                @ModelAttribute("subject") Subject subject) {
        Subject tempSubject = subjectService.getSubjectById(id);
        LOGGER.info("Old value: " + tempSubject.toString());
        tempSubject.setTitle(subject.getTitle());
        tempSubject.setHours(subject.getHours());
        subjectService.updateSubject(tempSubject);
        LOGGER.info("New value: " + tempSubject.toString());
        LOGGER.info("Subject with id " + id + " is edited successfully.");
        return "redirect:/subjects";
    }
}
