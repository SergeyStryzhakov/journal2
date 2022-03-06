package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Mark;
import com.lab3.journal2.entities.Student;
import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.services.MarkService;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class JournalController {
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
        return "journal";
    }

    @GetMapping(value = "/journal/students/{id}")
    public String showMarksByStudentId(Model model, @PathVariable int id) {
        Student student = studentService.getStudentById(id);
        List<Subject> subjects = subjectService.getAllSubjects();
        List<Mark> marks = markService.getMarksByStudentId(id);
        SortedMap<String, Map<String, Integer>> markList = new TreeMap<>(Collections.reverseOrder());

        marks.forEach(mark -> markList.put(mark.getCreated(), new HashMap<>()));
        for (Mark mark : marks) {
            if (markList.containsKey(mark.getCreated())) {
                if (markList.get(mark.getCreated()).isEmpty()) {
                    Map<String, Integer> tempMap = new HashMap<>();
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
        return "marks";
    }

    @GetMapping(value = "/journal/new")
    public String createMarkForm(Model model) {
        Mark mark = new Mark();
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("mark", mark);
        return "create_mark";
    }

    @PostMapping("/journal")
    public String createMark(@ModelAttribute("mark") Mark mark) {

        markService.createMark(mark);
        return "redirect:/journal";
    }

    @GetMapping(value = "/journal/edit/{id}")
    public String editMarkForm(Model model, @PathVariable int id) {
        model.addAttribute("mark", markService.getMarkById(id));
        return "edit_mark";
    }

    @PostMapping(value = "/journal/{id}")
    public String editMark(@PathVariable int id,
                           @ModelAttribute("mark") Mark mark) {
//        Mark tempMark = markService.getMarkById(id);
//        tempMark.setId(id);
//        tempMark.setStudent(mark.getStudent());
//        tempMark.setSubject(mark.getSubject());
//        tempMark.setTeacher(mark.getTeacher());
//        tempMark.setCreated(mark.getCreated());
//        tempMark.setValue(mark.getValue());
        markService.updateMark(mark);
        return "redirect:/journal";
    }
}
