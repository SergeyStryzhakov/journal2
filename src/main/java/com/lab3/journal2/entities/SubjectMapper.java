package com.lab3.journal2.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();
        subject.setId(rs.getInt("SUBJECT_ID"));
        subject.setTitle(rs.getString("TITLE"));
        subject.setHours(rs.getInt("HOURS"));
        return subject;
    }
}
