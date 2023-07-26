package com.codegym.ss8_bai1.service;

import com.codegym.ss8_bai1.model.User;
import com.codegym.ss8_bai1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(User user) {
        User newUser = userRepository.save(user);
        if (newUser!=null){
            return  true;
        }
        return false;
    }
}
