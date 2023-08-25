package com.example.ktmodule4.service.customer;

import com.example.ktmodule4.model.Customer;
import com.example.ktmodule4.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findAll();
}
