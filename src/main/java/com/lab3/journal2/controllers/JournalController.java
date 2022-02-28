package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Mark;
import com.lab3.journal2.entities.Student;
import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.services.MarkService;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JournalController {
    StudentService studentService;
    SubjectService subjectService;
    MarkService markService;


    public JournalController(StudentService studentService, SubjectService subjectService, MarkService markService) {
        super();
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.markService = markService;
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

    @GetMapping(value = "/journal/{id}")
    public String showMarksByStudentId(Model model, @PathVariable int id) {
        Student student = studentService.getStudentById(id);
        List<Subject> subjects = subjectService.getAllSubjects();
        List<Mark> marks = markService.getMarksByStudentId(id);
        Map<String, Map<String, Integer>> markList = new HashMap<>();
        marks.forEach(mark -> markList.put(mark.getCreated(), new HashMap<>()));
        for (Mark mark: marks) {
            if(markList.containsKey(mark.getCreated())) {
                if(markList.get(mark.getCreated()).isEmpty()){
                    Map<String, Integer> tempMap = new HashMap<>();
                    subjects.forEach(subject -> tempMap.put(subject.getTitle(),null));
                    markList.put(mark.getCreated(), tempMap);
                }
                markList.get(mark.getCreated()).put(mark.getSubject().getTitle(), mark.getValue());
            }
        }
        model.addAttribute("student", student);
        model.addAttribute("subjects", subjects);
        model.addAttribute("marks", markList);
        return "marks";
    }
}
