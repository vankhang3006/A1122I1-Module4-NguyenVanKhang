package com.codegym.repository;

import com.codegym.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository{
    private static List<Mail> mailList = new ArrayList<>();
    static {
        mailList.add(new Mail(1,"English",5,true,"Hulk, Big Green like Smash"));
        mailList.add(new Mail(2,"Chinese",10,true,"Thor, Strongest Avengers"));
        mailList.add(new Mail(3,"Japanese",15,false,"Iron Man, Rich, Billionaire"));
        mailList.add(new Mail(4,"Vietnamese",25,false,"Black Widow, Agent of Shield"));
        mailList.add(new Mail(5,"English",50,true,"Hawkeye, Agent of Shield, Never miss"));
        mailList.add(new Mail(6,"Vietnamese",100,false,"Captain America, Leader of heroes"));

    }
    public MailRepository() {
    }

    @Override
    public List<Mail> findAll() {
        return mailList;
    }

    @Override
    public Mail findById(int id) {
        for(int i=0;i<mailList.size();i++){
            if (mailList.get(i).getId()==id){
                return mailList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean save(Mail mail) {
        return mailList.add(mail);
    }

    @Override
    public List<Mail> editById(int id, String language, int page, boolean filter, String signature) {
        Mail mail = mailList.get(id);
        mail.setLanguage(language);
        mail.setPage(page);
        mail.setFilter(filter);
        mail.setSignature(signature);
        mailList.add(id,mail);
        return mailList;
    }
}
