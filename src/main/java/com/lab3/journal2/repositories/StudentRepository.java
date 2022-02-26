package com.lab3.journal2.repositories;


import com.lab3.journal2.entities.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student getById(int id);

    int update(Student student);

    void deleteById(int id);

    void create(Student student);
}
