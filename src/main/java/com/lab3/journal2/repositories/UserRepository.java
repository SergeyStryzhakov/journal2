package com.lab3.journal2.repositories;

import com.lab3.journal2.entities.User;

import java.util.List;

public interface UserRepository {

    void create(User user);

    List<User> findAll();

    void remove(String name);
}
