package com.example.case_study.service;

import com.example.case_study.model.user.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    Message findById(Long id);

    void save(Message customer);

    void remove(Long id);
}
