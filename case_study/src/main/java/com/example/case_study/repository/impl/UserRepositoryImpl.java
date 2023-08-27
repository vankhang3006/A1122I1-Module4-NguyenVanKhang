package com.example.case_study.repository.impl;

import com.example.case_study.model.user.User;
import com.example.case_study.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("select u from User u",User.class);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id =: id",User.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(User model) {
        if(model != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        User user = findById(id);
        em.remove(user);
    }
}