package com.lab3.journal2.services;

import com.lab3.journal2.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(int id);

    Teacher saveTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void removeTeacher(int id);

}
