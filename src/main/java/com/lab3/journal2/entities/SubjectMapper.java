package com.lab3.journal2.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for subject entity
 */
public class SubjectMapper implements RowMapper<Subject> {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectMapper.class);

    @Override
    public Subject mapRow(ResultSet rs, int rowNum) {
        Subject subject = new Subject();
        try {
            subject.setId(rs.getInt("SUBJECT_ID"));
            subject.setTitle(rs.getString("TITLE"));
            subject.setHours(rs.getInt("HOURS"));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return subject;
    }
}
