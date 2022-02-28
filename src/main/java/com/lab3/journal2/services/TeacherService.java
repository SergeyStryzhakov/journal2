package com.lab3.journal2.services;

import com.lab3.journal2.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    List<Teacher> getAllTeachersBySubject(int id);

    Teacher getTeacherById(int id);

    void createTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    void removeTeacher(int id);

}
