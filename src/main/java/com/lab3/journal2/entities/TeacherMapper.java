package com.lab3.journal2.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("TEACHER_ID"));
        teacher.setFirstName(rs.getString("TEACHER_FNAME"));
        teacher.setLastName(rs.getString("TEACHER_LNAME"));
        teacher.setSalary(rs.getFloat("SALARY"));
        teacher.setSubject(rs.getInt("SUBJECT"));
        return teacher;
    }
}
