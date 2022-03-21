package com.lab3.journal2.api;

import com.lab3.journal2.services.MarkService;
import com.lab3.journal2.services.StudentService;
import com.lab3.journal2.services.SubjectService;
import com.lab3.journal2.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(RESTController.class);

    public RESTController(TeacherService teacherService,
                          StudentService studentService,
                          SubjectService subjectService,
                          MarkService markService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.markService = markService;
    }

    @PostMapping(value = "/api/teachers/by_subject")
    public ResponseEntity<?> getTeachersBySubjectId(
            @ModelAttribute("subjectId") int id) {
        LOGGER.info("PostMapping(value = \"/api/teachers/by_subject\"");
        return ResponseEntity.ok(
                teacherService.getAllTeachersBySubject(id));
    }

    @PostMapping(value = "/api/marks/by_subject")
    public ResponseEntity<?> getMarksBySubjectId(
            @ModelAttribute("subjectId") int id) {
        LOGGER.info("@PostMapping(value = \"/api/marks/by_subject\")");
        return ResponseEntity.ok(
                markService.getMarksBySubjectId(id));
    }

    @GetMapping(value = "/api/teachers")
    public ResponseEntity<?> getAllTeachers() {
        LOGGER.info("@GetMapping(value = \"/api/teachers\")\n");
        return ResponseEntity.ok(
                teacherService.getAllTeachers());
    }

    @GetMapping(value = "/api/students")
    public ResponseEntity<?> getAllStudents() {
        LOGGER.info("@GetMapping(value = \"/api/students\")");
        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    @GetMapping(value = "/api/subjects")
    public ResponseEntity<?> getAllSubjects() {
        LOGGER.info(" @GetMapping(value = \"/api/subjects\")");
        return ResponseEntity.ok(
                subjectService.getAllSubjects());
    }

    @GetMapping(value = "/api/marks")
    public ResponseEntity<?> getAllMarks() {
        LOGGER.info("@GetMapping(value = \"/api/marks\")");
        return ResponseEntity.ok(
                markService.getAllMarks());
    }
}
