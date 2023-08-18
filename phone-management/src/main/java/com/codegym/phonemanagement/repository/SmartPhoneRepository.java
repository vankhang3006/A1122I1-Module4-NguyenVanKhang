package com.codegym.phonemanagement.repository;

import com.codegym.phonemanagement.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
}
