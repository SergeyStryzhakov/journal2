package com.lab3.journal2.services;

import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        super();
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(int id) {
        return subjectRepository.getById(id);
    }

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.create(subject);
    }


    @Override
    public int updateSubject(Subject subject) {
        return subjectRepository.update(subject);
    }

    @Override
    public void removeSubject(int id) {
        subjectRepository.deleteById(id);
    }
}
