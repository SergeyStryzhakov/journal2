package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.MarkMapper;
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
        String sqlString = "SELECT * from " +
                "lab3_ssm_teachers t, " +
                "lab3_ssm_subjects sub WHERE " +
                "t.subject = sub.subject_id ORDER BY t.TEACHER_LNAME";
        return jdbcTemplate.query(sqlString, new TeacherMapper());
    }

    @Override
    public List<Teacher> getBySubjectId(int id) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_teachers t, " +
                "lab3_ssm_subjects sub WHERE " +
                "t.subject = sub.subject_id AND " +
                "sub.SUBJECT_ID = ? ORDER BY t.TEACHER_ID";
        return jdbcTemplate.query(sqlString, new TeacherMapper(), id);
    }

    @Override
    public Teacher getById(int id) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_teachers t, " +
                "lab3_ssm_subjects sub WHERE " +
                "t.subject = sub.subject_id AND " +
                "t.TEACHER_ID = ? ORDER BY t.TEACHER_ID";
        return jdbcTemplate.queryForObject(sqlString, new TeacherMapper(), id);
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
                teacher.getSubject().getId(),
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
                teacher.getSubject().getId());
    }
}
