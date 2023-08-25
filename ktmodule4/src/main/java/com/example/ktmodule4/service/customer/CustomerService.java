package com.example.ktmodule4.service.customer;

import com.example.ktmodule4.model.Customer;
import com.example.ktmodule4.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
