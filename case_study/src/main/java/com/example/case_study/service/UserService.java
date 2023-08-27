package com.example.case_study.service;

import com.example.case_study.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
