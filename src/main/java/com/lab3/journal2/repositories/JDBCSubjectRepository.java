package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.Subject;
import com.lab3.journal2.entities.SubjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCSubjectRepository implements SubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public JDBCSubjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Subject> findAll() {
        return jdbcTemplate.query("select * from LAB3_SSM_SUBJECTS", new SubjectMapper());
    }

    @Override
    public Subject getById(int id) {
        return jdbcTemplate.queryForObject("select * from LAB3_SSM_SUBJECTS WHERE SUBJECT_ID = ?",
               new SubjectMapper(), id);
    }

    @Override
    public int update(Subject subject) {
        return jdbcTemplate.update("update LAB3_SSM_SUBJECTS set TITLE = ?, HOURS = ? WHERE SUBJECT_ID = ?",
                subject.getTitle(),
                subject.getHours(),
                subject.getId());
    }

    @Override
    public void create(Subject subject) {
        jdbcTemplate.update("insert into LAB3_SSM_SUBJECTS(TITLE, HOURS) values (?,?)",
                subject.getTitle(),
                subject.getHours());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from LAB3_SSM_SUBJECTS where SUBJECT_ID = ?", id);
    }
}
