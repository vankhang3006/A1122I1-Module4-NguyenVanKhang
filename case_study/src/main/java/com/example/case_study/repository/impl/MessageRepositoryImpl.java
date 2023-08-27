package com.example.case_study.repository.impl;

import com.example.case_study.model.user.Message;
import com.example.case_study.repository.MessageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class MessageRepositoryImpl implements MessageRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Message> findAll() {
        TypedQuery<Message> query = em.createQuery("select m from Message m", Message.class);
        return query.getResultList();
    }

    @Override
    public Message findById(Long id) {
        TypedQuery<Message> query = em.createQuery("select m from Message m where m=:id", Message.class);
        try {
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Message model) {
        if(model.getId() != null){
            em.merge(model);
        }else{
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Message message = findById(id);
        if(message != null){
            em.remove(message);
        }
    }
}
