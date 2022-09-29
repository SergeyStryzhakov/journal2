package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Mark;
import com.lab3.journal2.entities.MarkMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCMarkRepository implements MarkRepository {
    private final JdbcTemplate jdbcTemplate;


    public JDBCMarkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Mark> findAll() {
        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id ORDER BY m.CREATED";
        return jdbcTemplate.query(sqlString, new MarkMapper());
    }

    @Override
    public List<Mark> getByStudentId(int id) {

        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id AND " +
                "s.STUDENT_ID = ? ORDER BY m.CREATED ";
        return jdbcTemplate.query(sqlString, new MarkMapper(), id);
    }

    @Override
    public List<Mark> getByTeacherId(int id) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id AND " +
                "t.TEACHER_ID = ? ORDER BY m.CREATED";
        return jdbcTemplate.query(sqlString, new MarkMapper(), id);
    }

    @Override
    public List<Mark> getBySubjectId(int id) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id AND " +
                "sub.SUBJECT_ID = ? ORDER BY m.CREATED ";
        return jdbcTemplate.query(sqlString, new MarkMapper(), id);
    }

    @Override
    public List<Mark> getByDate(String date) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id AND " +
                "m.CREATED = to_date(?, 'YYYY.MM.DD') ORDER BY s.STUDENT_LNAME";
        return jdbcTemplate.query(sqlString, new MarkMapper(), date);
    }

    @Override
    public Mark getById(int id) {
        String sqlString = "SELECT * from " +
                "lab3_ssm_marks m, " +
                "lab3_ssm_students s, " +
                "lab3_ssm_subjects sub, " +
                "lab3_ssm_teachers t WHERE " +
                "m.student_id = s.student_id AND " +
                "m.teacher_id = t.teacher_id AND " +
                "m.subject_id = sub.subject_id AND " +
                "m.MARK_ID = ?";
        return jdbcTemplate.queryForObject(sqlString, new MarkMapper(), id);
    }

    @Override
    public void create(Mark mark) {
        jdbcTemplate.update("insert into LAB3_SSM_MARKS(" +
                        "STUDENT_ID, SUBJECT_ID, CREATED, " +
                        "VALUE, TEACHER_ID) values (?,?,to_date(?, 'YYYY.MM.DD'),?,?)",
                mark.getStudent().getId(),
                mark.getSubject().getId(),
                mark.getCreated(),
                mark.getValue(),
                mark.getTeacher().getId());
    }

    @Override
    public int update(Mark mark) {
        return jdbcTemplate.update("update LAB3_SSM_MARKS " +
                        "SET STUDENT_ID = ?, SUBJECT_ID = ?," +
                        " CREATED = to_date(?, 'YYYY.MM.DD'), VALUE = ?, TEACHER_ID = ? " +
                        "where MARK_ID = ?",
                mark.getStudent().getId(),
                mark.getSubject().getId(),
                mark.getCreated(),
                mark.getValue(),
                mark.getTeacher().getId(),
                mark.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from LAB3_SSM_MARKS where MARK_ID = ?", id);
    }
}
