package com.example.thi.service.impl;

import com.example.thi.model.Question;
import com.example.thi.repository.IQuestionRepository;
import com.example.thi.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;
    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findByTitleContainingAndType_NameContaining(String title, String type, Pageable pageable) {
        return questionRepository.findByTitleContainingAndType_NameContaining(title, type, pageable);
    }
}
