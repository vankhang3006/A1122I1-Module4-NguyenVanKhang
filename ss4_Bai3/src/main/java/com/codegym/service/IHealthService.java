package com.codegym.service;

import com.codegym.model.Health;

import java.util.List;

public interface IHealthService {
    List<Health> findAll();

    void save(Health health);

    Health findById(int id);

    void update(int id, Health health);
}
