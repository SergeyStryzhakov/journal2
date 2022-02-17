package com.lab3.journal2.services;

import com.lab3.journal2.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void removeStudent(int id);

}
