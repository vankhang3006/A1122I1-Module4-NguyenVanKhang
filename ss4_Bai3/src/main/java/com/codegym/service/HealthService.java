package com.codegym.service;


import com.codegym.model.Health;

import java.util.ArrayList;
import java.util.List;

public class HealthService implements IHealthService{
    private List<Health> healths = new ArrayList<>();

    @Override
    public List<Health> findAll() {
        return healths;
    }

    @Override
    public void save(Health health) {
        healths.add(health);
    }

    @Override
    public Health findById(int id) {
        return healths.get(id-1);
    }

    @Override
    public void update(int id, Health health) {
        for (int i = 0; i < healths.size(); i++) {
            Health p = healths.get(i);
            if (p.getId() == id) {
                healths.set(i, health);
                break;
            }
        }
    }
}
