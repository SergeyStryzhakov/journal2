package com.lab3.journal2.services;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.repositories.MarkRepository;
import com.lab3.journal2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO Read about @Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    public StudentServiceImpl(StudentRepository studentRepository, MarkRepository markRepository) {
        super();
        this.studentRepository = studentRepository;
        this.markRepository = markRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepository.getById(id);
        student.setMarkList(markRepository.getByStudentId(id));
        return student;
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
