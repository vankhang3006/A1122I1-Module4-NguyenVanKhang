package com.codegym.ss7_bai2.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
