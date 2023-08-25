package com.example.ktmodule4.service.stadium;

import com.example.ktmodule4.model.Stadium;
import com.example.ktmodule4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStadiumService extends IGeneralService<Stadium> {
//    Page<Stadium> findByNameContaining(String name, Pageable pageable);
//    Page<Stadium> findByArea_NameContaining(String name, Pageable pageable);
//    Page<Stadium> findByType_PeopleAmountContaining(String peopleAmount, Pageable pageable);
    Page<Stadium> findAll(Pageable pageable);
    Page<Stadium> findByNameContainingAndArea_NameContainingAndType_PeopleAmountContaining(String name, String area, String peopleAmount, Pageable pageable);
    boolean isNameUnique(String name);
}
