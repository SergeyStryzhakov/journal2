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

    /**
     * Get teachers list by subject id in JSON format
     *
     * @param id subject id
     * @return JSON teachers list
     */
    @PostMapping(value = "/api/teachers/subject")
    public ResponseEntity<?> getTeachersBySubjectId(
            @ModelAttribute("subjectId") int id) {
        LOGGER.info("(JSON) Get teachers by subject id: " + id);
        return ResponseEntity.ok(
                teacherService.getAllTeachersBySubject(id));
    }

    /**
     * Get marks list by subject id in JSON format
     *
     * @param id subject id
     * @return JSON marks list
     */
    @PostMapping(value = "/api/marks/subject")
    public ResponseEntity<?> getMarksBySubjectId(
            @ModelAttribute("subjectId") int id) {
        LOGGER.info("(JSON) Get marks by subject id: " + id);
        return ResponseEntity.ok(
                markService.getMarksBySubjectId(id));
    }
    /**
     * Get marks list by teacher id in JSON format
     *
     * @param id teacher id
     * @return JSON marks list
     */
    @PostMapping(value = "/api/marks/teacher")
    public ResponseEntity<?> getMarksByTeacherId(
            @ModelAttribute("teacherId") int id) {
        LOGGER.info("(JSON) Get marks by teacher id: " + id);
        return ResponseEntity.ok(
                markService.getMarksByTeacherId(id));
    }
    /**
     * Get marks list by date in JSON format
     *
     * @param date Date
     * @return JSON marks list
     */
    @PostMapping(value = "/api/marks/date")
    public ResponseEntity<?> getMarksByDate(
            @ModelAttribute("date") String date) {
        LOGGER.info("(JSON) Get marks by date: " + date);
        return ResponseEntity.ok(
                markService.getMarksByDate(date));
    }

    /**
     * Get teachers list in JSON format
     *
     * @return JSON teachers list
     */
    @GetMapping(value = "/api/teachers")
    public ResponseEntity<?> getAllTeachers() {
        LOGGER.info("(JSON) Get all teachers");
        return ResponseEntity.ok(
                teacherService.getAllTeachers());
    }

    /**
     * Get students list in JSON format
     *
     * @return JSON students list
     */
    @GetMapping(value = "/api/students")
    public ResponseEntity<?> getAllStudents() {
        LOGGER.info("(JSON) Get all students)");
        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    /**
     * Get subjects list in JSON format
     *
     * @return JSON subjects list
     */
    @GetMapping(value = "/api/subjects")
    public ResponseEntity<?> getAllSubjects() {
        LOGGER.info("(JSON) Get all subjects)");
        return ResponseEntity.ok(
                subjectService.getAllSubjects());
    }

    /**
     * Get marks list in JSON format
     *
     * @return JSON marks list
     */
    @GetMapping(value = "/api/marks")
    public ResponseEntity<?> getAllMarks() {
        LOGGER.info("(JSON) Get all marks)");
        return ResponseEntity.ok(
                markService.getAllMarks());
    }
}
