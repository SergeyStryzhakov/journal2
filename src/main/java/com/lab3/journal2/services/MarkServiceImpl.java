package com.lab3.journal2.services;

import com.lab3.journal2.entities.Mark;
import com.lab3.journal2.repositories.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @Override
    public List<Mark> getMarksByStudentId(int id) {
        return markRepository.getByStudentId(id);
    }

    @Override
    public List<Mark> getMarksByTeacherId(int id) {
        return markRepository.getByTeacherId(id);
    }

    @Override
    public List<Mark> getMarksBySubjectId(int id) {
        return markRepository.getBySubjectId(id);
    }

    @Override
    public List<Mark> getMarksByDate(String date) {
        return markRepository.getByDate(date);
    }


    @Override
    public Mark getMarkById(int id) {
        return markRepository.getById(id);
    }

    @Override
    public void updateMark(Mark mark) {
        markRepository.update(mark);
    }

    @Override
    public void createMark(Mark mark) {
        markRepository.create(mark);
    }

    @Override
    public void deleteMark(int id) {
        markRepository.deleteById(id);
    }
}
