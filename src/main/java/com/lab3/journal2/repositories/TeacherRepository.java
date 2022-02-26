package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();

    Teacher getById(int id);

    int update(Teacher teacher);

    void deleteById(int id);

    void create(Teacher teacher);
}
