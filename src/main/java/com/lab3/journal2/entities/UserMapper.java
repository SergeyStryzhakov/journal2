package com.lab3.journal2.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        try {
            user.setLogin(rs.getString("USERNAME"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setRole(Role.valueOf(rs.getString("ROLE")));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return user;
    }
}
