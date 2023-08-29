package com.example.thi.repository;

import com.example.thi.model.Question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findByTitleContainingAndType_NameContaining(String title, String type, Pageable pageable);
}
