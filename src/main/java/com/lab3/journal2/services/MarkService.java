package com.lab3.journal2.services;

import com.lab3.journal2.entities.Mark;

import java.util.List;


public interface MarkService {
    List<Mark> getAllMarks();
    List<Mark> getMarksByStudentId(int id);
    Mark getMarkById(int id);
    void updateMark(Mark mark);
    void createMark(Mark mark);
    void deleteMark(int id);
}
