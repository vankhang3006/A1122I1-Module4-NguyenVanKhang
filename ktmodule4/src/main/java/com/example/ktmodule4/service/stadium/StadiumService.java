package com.example.ktmodule4.service.stadium;

import com.example.ktmodule4.model.Stadium;
import com.example.ktmodule4.repository.IStadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StadiumService implements IStadiumService{
    @Autowired
    private IStadiumRepository stadiumRepository;
    @Override
    public Iterable<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    @Override
    public Optional<Stadium> findById(int id) {
        return stadiumRepository.findById(id);
    }

    @Override
    public void save(Stadium stadium) {
        stadiumRepository.save(stadium);
    }

    @Override
    public void remove(int id) {
        stadiumRepository.deleteById(id);
    }

//    @Override
//    public Page<Stadium> findByNameContaining(String name, Pageable pageable) {
//        return stadiumRepository.findByNameContaining(name, pageable);
//    }
//
//    @Override
//    public Page<Stadium> findByArea_NameContaining(String name, Pageable pageable) {
//        return stadiumRepository.findByArea_NameContaining(name, pageable);
//    }
//
//    @Override
//    public Page<Stadium> findByType_PeopleAmountContaining(String peopleAmount, Pageable pageable) {
//        return stadiumRepository.findByType_PeopleAmountContaining(peopleAmount,pageable);
//    }


    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable);
    }

    @Override
    public Page<Stadium> findByNameContainingAndArea_NameAndType_PeopleAmount(String name, String area, String peopleAmount, Pageable pageable) {
        return stadiumRepository.findByNameContainingAndArea_NameContainingAndType_PeopleAmountContaining(name, area, peopleAmount, pageable);
    }

    @Override
    public boolean isNameUnique(String name) {
        Stadium existingStadium = stadiumRepository.findByName(name);
        return existingStadium == null;
    }
}
