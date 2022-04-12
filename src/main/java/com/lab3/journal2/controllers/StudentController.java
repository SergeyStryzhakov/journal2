package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    /**
     * Get all students from DB
     *
     * @param model model
     * @return list of all students
     */
    @GetMapping()
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    /**
     * Get specific student by id
     *
     * @param model model
     * @param id    student id
     * @return specific student object
     */
    @GetMapping(value = "/{id}")
    public String showStudent(Model model, @PathVariable int id) {
        model.addAttribute("students", studentService.getStudentById(id));
        return "students";
    }

    /**
     * Create form for making new student
     *
     * @param model model
     * @return html form
     */
    @GetMapping(value = "/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    /**
     * Add new student in DB
     *
     * @param student new student
     * @return students.html with list of all students
     */
    @PostMapping()
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        LOGGER.info("Student is created successfully. " + student.toString() );
        return "redirect:/students";
    }

    /**
     * Remove student by id
     *
     * @param id student id
     * @return students.html with list of all students
     */
    @GetMapping(value = "/remove/{id}")
    public String removeStudent(@PathVariable int id) {
        studentService.removeStudent(id);
        LOGGER.info("Student with id " + id + " is removed successfully.");
        return "redirect:/students";
    }

    /**
     * Create form for editing student by id
     *
     * @param model model
     * @param id    student id
     * @return html form for edit
     */
    @GetMapping(value = "/edit/{id}")
    public String editStudentForm(Model model, @PathVariable int id) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    /**
     * Update students record in DB
     *
     * @param id      student id
     * @param student student entity
     * @param model   model
     * @return students.html with list of all students
     */
    @PostMapping(value = "/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        Student tempStudent = studentService.getStudentById(id);
        LOGGER.info("Old value: " + tempStudent.toString());
        tempStudent.setId(id);
        tempStudent.setFirstName(student.getFirstName());
        tempStudent.setLastName(student.getLastName());
        tempStudent.setAge(student.getAge());
        tempStudent.setGroupName(student.getGroupName());
        studentService.updateStudent(tempStudent);
        LOGGER.info("New value: " + tempStudent.toString());
        LOGGER.info("Student with id " + id + " is edited successfully.");
        return "redirect:/students";
    }
}
