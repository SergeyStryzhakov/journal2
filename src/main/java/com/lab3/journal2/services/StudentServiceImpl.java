package com.lab3.journal2.services;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO Read about @Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

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
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }
}
