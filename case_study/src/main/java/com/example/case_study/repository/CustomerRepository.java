package com.example.case_study.repository;

import com.example.case_study.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
