package com.codegym.ss8_bai1.service;

import com.codegym.ss8_bai1.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    boolean save(User user);
}
