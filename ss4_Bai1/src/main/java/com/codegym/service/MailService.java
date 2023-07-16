package com.codegym.service;

import com.codegym.model.Mail;
import com.codegym.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService{
    @Autowired
    private IMailRepository mailRepository;

    @Override
    public List<Mail> findAll() {
        return mailRepository.findAll();
    }

    @Override
    public Mail findById(int id) {
        return mailRepository.findById(id);
    }

    @Override
    public boolean save(Mail mail) {
        return mailRepository.save(mail);
    }

    @Override
    public List<Mail> editById(int id, String language, int page, boolean filter, String signature) {
        return mailRepository.editById(id,language,page,filter,signature);
    }
}
