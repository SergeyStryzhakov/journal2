package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Teacher;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/teachers")
public class TeacherController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;
    private final SubjectService subjectService;

    public TeacherController(TeacherService teacherService, SubjectService subjectService) {
        super();
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    /**
     * Get list all teachers
     *
     * @param model model
     * @return list all teachers
     */
    @GetMapping()
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    /**
     * Get specific teacher by id
     *
     * @param model model
     * @param id    teacher id
     * @return teacher entity
     */

    @GetMapping(value = "/{id}")
    public String showTeacher(Model model, @PathVariable int id) {
        model.addAttribute("teachers", teacherService.getTeacherById(id));
        LOGGER.info("Teacher with id " + id + " is returned successfully.");
        return "teachers";
    }

    /**
     * Create form for making new teacher
     *
     * @param model model
     * @return html form
     */
    @GetMapping(value = "/new")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "create_teacher";
    }

    /**
     * Add new teacher in DB
     *
     * @param teacher entity
     * @return list all teachers
     */
    @PostMapping()
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.createTeacher(teacher);
        LOGGER.info("Teacher created: " + teacher.toString());
        return "redirect:/teachers";
    }

    /**
     * Remove teacher from DB by id
     *
     * @param id teacher id
     * @return list of all teachers
     */
    @GetMapping(value = "/remove/{id}")
    public String removeTeacher(@PathVariable int id) {
        teacherService.removeTeacher(id);
        LOGGER.info("Teacher with id " + id + " is removed successfully.");
        return "redirect:/teachers";
    }

    /**
     * Create form for edit teacher entity
     *
     * @param model model
     * @param id    teacher id
     * @return html edit form
     */
    @GetMapping(value = "/edit/{id}")
    public String editTeacherForm(Model model, @PathVariable int id) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "edit_teacher";
    }

    /**
     * Update teacher entity in DB
     *
     * @param id      teacher
     * @param teacher entity
     * @return list all teachers
     */
    @PostMapping(value = "/{id}")
    public String updateTeacher(@PathVariable int id,
                                @ModelAttribute("teacher") Teacher teacher) {
        Teacher tempTeacher = teacherService.getTeacherById(id);
        LOGGER.info("Old value: " + tempTeacher.toString());
        tempTeacher.setId(id);
        tempTeacher.setFirstName(teacher.getFirstName());
        tempTeacher.setLastName(teacher.getLastName());
        tempTeacher.setSalary(teacher.getSalary());
        tempTeacher.setSubject(teacher.getSubject());
        teacherService.updateTeacher(tempTeacher);
        LOGGER.info("New value: " + tempTeacher.toString());
        LOGGER.info("Teacher`s info is edited successfully.");
        return "redirect:/teachers";
    }
}
