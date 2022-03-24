package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Student;
import com.lab3.journal2.entities.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCStudentRepository implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JDBCStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from LAB3_SSM_STUDENTS ORDER BY STUDENT_LNAME", new StudentMapper());
    }

    @Override
    public Student getById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from LAB3_SSM_STUDENTS WHERE STUDENT_ID = ?",
                new StudentMapper(), id);
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("update LAB3_SSM_STUDENTS set " +
                        "STUDENT_FNAME = ?, " +
                        "STUDENT_LNAME = ?, " +
                        "AGE = ?, " +
                        "GROUPNAME = ? WHERE " +
                        "STUDENT_ID = ?",
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getGroupName(),
                student.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from LAB3_SSM_STUDENTS where STUDENT_ID = ?", id);
    }

    @Override
    public void create(Student student) {
        jdbcTemplate.update("insert into LAB3_SSM_STUDENTS(STUDENT_FNAME,STUDENT_LNAME,AGE,GROUPNAME) values (?,?,?,?)",
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getGroupName());
    }
}
