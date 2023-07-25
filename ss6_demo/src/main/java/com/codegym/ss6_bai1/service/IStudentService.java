package com.codegym.ss6_bai1.service;



import com.codegym.ss6_bai1.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> search(String searchName);
    Student findById(int id);
    boolean save(Student student);
}
