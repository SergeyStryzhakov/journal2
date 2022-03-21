package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Mark;
import com.lab3.journal2.entities.Student;
import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.services.MarkService;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class JournalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(JournalController.class);
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final MarkService markService;
    private final TeacherService teacherService;


    public JournalController(StudentService studentService,
                             SubjectService subjectService,
                             MarkService markService,
                             TeacherService teacherService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.markService = markService;
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/journal")
    public String showJournal(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Subject> subjects = subjectService.getAllSubjects();
        List<Mark> marks = markService.getAllMarks();
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("marks", marks);
        return "journal";
    }

    @GetMapping(value = "/journal/teachers/{id}")
    public String showJournalByTeacher(Model model, @PathVariable int id) {
        List<Student> students = studentService.getAllStudents();
        List<Subject> subjects = subjectService.getAllSubjects();
        List<Mark> marks = markService.getMarksByTeacherId(id);
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("marks", marks);
        LOGGER.info("Journal by teacher with id " + id + " created successfully.");
        return "journal";
    }

    @GetMapping(value = "/journal/students/{id}")
    public String showMarksByStudentId(Model model, @PathVariable int id) {
        Student student = studentService.getStudentById(id);
        List<Subject> subjects = subjectService.getAllSubjects();
        List<Mark> marks = markService.getMarksByStudentId(id);
        Map<String, Map<String, Integer>> markList = new TreeMap<>(Collections.reverseOrder());
        marks.forEach(mark -> markList.put(mark.getCreated(), new HashMap<>()));
        for (Mark mark : marks) {
            if (markList.containsKey(mark.getCreated())) {
                if (markList.get(mark.getCreated()).isEmpty()) {
                    Map<String, Integer> tempMap = new TreeMap<>();
                    subjects.forEach(subject -> tempMap.put(subject.getTitle(), null));
                    markList.put(mark.getCreated(), tempMap);
                }
                markList.get(
                        mark.getCreated()).put(
                        mark.getSubject().getTitle(),
                        mark.getValue());
            }
        }
        model.addAttribute("student", student);
        model.addAttribute("subjects", subjects);
        model.addAttribute("marks", markList);
        LOGGER.info("Journal by student with id " + id + " created successfully.");
        return "marks";
    }

    @PostMapping(value = "/journal/students/{id}")
    public String createSimpleMark(@PathVariable int id,
                                   @ModelAttribute("subjectId") int subjectId,
                                   @ModelAttribute("teacherId") int teacherId,
                                   @ModelAttribute("created") String created,
                                   @ModelAttribute("value") int value) {
        Mark mark = new Mark();
        mark.setValue(value);
        mark.setCreated(created);
        mark.setTeacher(teacherService.getTeacherById(teacherId));
        mark.setSubject(subjectService.getSubjectById(subjectId));
        mark.setStudent(studentService.getStudentById(id));
        markService.createMark(mark);
        LOGGER.info("Mark created: " + mark);
        return "redirect:/journal/students/" + id;
    }

    @GetMapping(value = {"/journal/new/{id}"})
    public String createMarkForm(Model model, @PathVariable int id) {
        Mark mark = new Mark();
        List<Student> studentsList = new ArrayList<>();
        if (id == 0) {
            studentsList = studentService.getAllStudents();
        } else {
            studentsList.add(studentService.getStudentById(id));
        }
        model.addAttribute("students", studentsList);
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("mark", mark);
        LOGGER.info("Create mark form is ready.");
        return "create_mark";
    }

    @PostMapping("/journal")
    public String createMark(@ModelAttribute("mark") Mark mark) {
        markService.createMark(mark);
        LOGGER.info("Mark created: " + mark);
        return "redirect:/journal";
    }

    @GetMapping(value = "/journal/edit/{id}")
    public String editMarkForm(Model model, @PathVariable int id) {
        model.addAttribute("mark", markService.getMarkById(id));
        LOGGER.info("Edit form is ready.");
        return "edit_mark";
    }

    @PostMapping(value = "/journal/{id}")
    public String editMark(@PathVariable int id,
                           @ModelAttribute("mark") Mark mark) {
        markService.updateMark(mark);
        LOGGER.info("Mark is updated: " + mark);
        return "redirect:/journal";
    }

    @GetMapping(value = "/journal/remove/{id}")
    public String removeMark(@PathVariable int id) {
        markService.deleteMark(id);
        LOGGER.info("Mark with id " + id + " is deleted.");
        return "redirect:/journal";
    }
}
