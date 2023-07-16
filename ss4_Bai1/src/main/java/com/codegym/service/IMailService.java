package com.codegym.service;

import com.codegym.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> findAll();
    Mail findById(int id);
    boolean save(Mail mail);
    List<Mail> editById(int id, String language, int page, boolean filter, String signature);
}
