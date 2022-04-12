package com.lab3.journal2.services;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO Read about @Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }


    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.create(student);
    }
}
