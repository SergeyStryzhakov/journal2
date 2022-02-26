package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Subject;

import java.util.List;

public interface SubjectRepository {
    List<Subject> findAll();

    Subject getById(int id);

    int update(Subject subject);

    void create(Subject subject);

    void deleteById(int id);
}
