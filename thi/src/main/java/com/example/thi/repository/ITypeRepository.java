package com.example.thi.repository;

import com.example.thi.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {
}
