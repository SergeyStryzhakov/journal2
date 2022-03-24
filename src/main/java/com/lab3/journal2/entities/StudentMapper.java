package com.lab3.journal2.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for student entity
 */
public class StudentMapper implements RowMapper<Student> {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentMapper.class);

    @Override
    public Student mapRow(ResultSet rs, int rowNum) {
        Student student = new Student();
        try {
            student.setId(rs.getInt("STUDENT_ID"));
            student.setFirstName(rs.getString("STUDENT_FNAME"));
            student.setLastName(rs.getString("STUDENT_LNAME"));
            student.setAge(rs.getInt("AGE"));
            student.setGroupName(rs.getString("GROUPNAME"));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return student;
    }
}
