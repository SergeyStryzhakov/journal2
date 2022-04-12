package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.User;
import com.lab3.journal2.entities.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JDBCUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(User user) {
        jdbcTemplate.update("insert into LAB3_SSM_USERS(" +
                        "USERNAME, PASSWORD, ROLE) values (?,?,?)",
                user.getLogin(),
                user.getPassword(),
                user.getRole().toString());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM LAB3_SSM_USERS", new UserMapper());
    }

    @Override
    public void remove(String name) {
        jdbcTemplate.update("DELETE fROM LAB3_SSM_USERS WHERE USERNAME=?", name);
    }
}
