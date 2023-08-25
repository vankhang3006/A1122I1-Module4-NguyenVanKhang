package com.example.ktmodule4.repository;


import com.example.ktmodule4.model.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStadiumRepository extends JpaRepository<Stadium, Integer> {
    Stadium findByName(String name);
//    Page<Stadium> findByNameContaining(String name, Pageable pageable);
//    Page<Stadium> findByArea_NameContaining(String name, Pageable pageable);
//    Page<Stadium> findByType_PeopleAmountContaining(String peopleAmount, Pageable pageable);
    Page<Stadium> findByNameContainingAndArea_NameContainingAndType_PeopleAmountContaining(String name, String area, String peopleAmount, Pageable pageable);
}
