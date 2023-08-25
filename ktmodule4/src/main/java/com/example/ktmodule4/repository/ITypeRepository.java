package com.example.ktmodule4.repository;


import com.example.ktmodule4.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {
}
