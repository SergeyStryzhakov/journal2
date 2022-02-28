package com.lab3.journal2.entities;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkMapper implements RowMapper<Mark> {

    @Override
    public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mark mark = new Mark();
        mark.setId(rs.getInt("MARK_ID"));
        mark.setValue(rs.getInt("VALUE"));
        mark.setCreated(rs.getDate("CREATED").toString());
        mark.setStudent(new Student(
                rs.getInt("STUDENT_ID"),
                rs.getString("STUDENT_FNAME"),
                rs.getString("STUDENT_LNAME"),
                rs.getInt("AGE"),
                rs.getString("GROUPNAME")
        ));
        mark.setSubject(new Subject(
                rs.getInt("SUBJECT_ID"),
                rs.getString("TITLE"),
                rs.getInt("HOURS")));
        mark.setTeacher(new Teacher(
                rs.getInt("TEACHER_ID"),
                rs.getString("TEACHER_FNAME"),
                rs.getString("TEACHER_LNAME"),
                rs.getFloat("SALARY"),
                new Subject(
                        rs.getInt("SUBJECT_ID"),
                        rs.getString("TITLE"),
                        rs.getInt("HOURS"))));
        return mark;

    }
}
