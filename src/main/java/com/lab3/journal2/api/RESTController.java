package com.lab3.journal2.api;

import com.lab3.journal2.services.MarkService;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RESTController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final MarkService markService;

    public RESTController(TeacherService teacherService,
                          StudentService studentService,
                          SubjectService subjectService,
                          MarkService markService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.markService = markService;
    }

    @PostMapping(value = "/api/teachers")
    public ResponseEntity<?> getTeachersBySubjectId(
            @ModelAttribute("subjectId") int id) {
        return ResponseEntity.ok(
                teacherService.getAllTeachersBySubject(id));
    }

    @PostMapping(value = "/api/journal")
    public ResponseEntity<?> getMarksBySubjectId(
            @ModelAttribute("subjectId") int id) {
        return ResponseEntity.ok(
                markService.getMarksBySubjectId(id));
    }

    @GetMapping(value = "/api/teachers")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(
                teacherService.getAllTeachers());
    }

    @GetMapping(value = "/api/students")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    @GetMapping(value = "/api/subjects")
    public ResponseEntity<?> getAllSubjects() {
        return ResponseEntity.ok(
                subjectService.getAllSubjects());
    }
}
