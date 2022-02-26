package com.lab3.journal2.services;

import com.lab3.journal2.entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(int id);

    void createSubject(Subject subject);

    int updateSubject(Subject subject);

    void removeSubject(int id);
}
