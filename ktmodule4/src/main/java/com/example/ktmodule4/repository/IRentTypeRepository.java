package com.example.ktmodule4.repository;


import com.example.ktmodule4.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
    RentType findRentTypeById(int id);
}
