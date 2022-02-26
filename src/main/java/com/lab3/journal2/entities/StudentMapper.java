package com.lab3.journal2.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("STUDENT_ID"));
        student.setFirstName(rs.getString("STUDENT_FNAME"));
        student.setLastName(rs.getString("STUDENT_LNAME"));
        student.setAge(rs.getInt("AGE"));
        student.setGroupName(rs.getString("GROUPNAME"));
        return student;
    }
}
