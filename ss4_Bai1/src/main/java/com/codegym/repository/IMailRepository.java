package com.codegym.repository;

import com.codegym.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> findAll();
    Mail findById(int id);
    boolean save(Mail mail);
    List<Mail> editById(int id, String language, int page, boolean filter, String signature);
}
