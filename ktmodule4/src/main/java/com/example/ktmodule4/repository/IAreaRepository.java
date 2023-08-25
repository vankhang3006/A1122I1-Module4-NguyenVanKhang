package com.example.ktmodule4.repository;

import com.example.ktmodule4.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreaRepository extends JpaRepository<Area, Integer> {
    Area findAreaById(int id);
}
