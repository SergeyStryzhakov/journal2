package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Mark;

import java.util.List;

public interface MarkRepository {
    List<Mark> findAll();

    List<Mark> getByStudentId(int id);

    List<Mark> getByTeacherId(int id);

    List<Mark> getBySubjectId(int id);
    List<Mark> getByDate(String date);

    Mark getById(int id);

    void create(Mark mark);

    int update(Mark mark);

    void deleteById(int id);

}
