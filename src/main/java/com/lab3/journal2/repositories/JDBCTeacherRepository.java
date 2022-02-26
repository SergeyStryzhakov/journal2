package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Teacher;
import com.lab3.journal2.entities.TeacherMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCTeacherRepository implements TeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    public JDBCTeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query("select * from LAB3_SSM_TEACHERS", new TeacherMapper());
    }

    @Override
    public Teacher getById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from LAB3_SSM_TEACHERS WHERE TEACHER_ID = ?",
                new TeacherMapper(), id);
    }

    @Override
    public int update(Teacher teacher) {
        return jdbcTemplate.update("update LAB3_SSM_TEACHERS set " +
                        "TEACHER_FNAME = ?, " +
                        "TEACHER_LNAME = ?, " +
                        "SALARY = ?, " +
                        "SUBJECT = ? WHERE " +
                        "TEACHER_ID = ?",
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getSalary(),
                teacher.getSubject(),
                teacher.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from LAB3_SSM_TEACHERS " +
                "where TEACHER_ID = ?", id);
    }

    @Override
    public void create(Teacher teacher) {
        jdbcTemplate.update("insert into LAB3_SSM_TEACHERS(TEACHER_FNAME,TEACHER_LNAME,SALARY,SUBJECT) " +
                        "values (?,?,?,?)",
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getSalary(),
                teacher.getSubject());
    }
}
