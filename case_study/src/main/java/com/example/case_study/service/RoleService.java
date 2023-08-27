package com.example.case_study.service;

import com.example.case_study.model.user.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Long id);

    void save(Role role);

    void remove(Long id);
}
