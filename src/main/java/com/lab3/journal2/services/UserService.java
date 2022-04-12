package com.lab3.journal2.services;

import com.lab3.journal2.entities.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getAll();
    void deleteUser(String name);
}
