package com.lab3.journal2.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for teacher entity
 */
public class TeacherMapper implements RowMapper<Teacher> {
    private final static Logger LOGGER = LoggerFactory.getLogger(TeacherMapper.class);

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) {
        Teacher teacher = new Teacher();
        try {
            teacher.setId(rs.getInt("TEACHER_ID"));
            teacher.setFirstName(rs.getString("TEACHER_FNAME"));
            teacher.setLastName(rs.getString("TEACHER_LNAME"));
            teacher.setSalary(rs.getFloat("SALARY"));
            teacher.setSubject(new Subject(
                    rs.getInt("SUBJECT"),
                    rs.getString("TITLE"),
                    rs.getInt("HOURS")));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return teacher;
    }
}
