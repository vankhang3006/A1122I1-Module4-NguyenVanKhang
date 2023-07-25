package com.codegym.ss6_bai1.service;




import com.codegym.ss6_bai1.model.Student;
import com.codegym.ss6_bai1.reposiotry.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String searchName) {
        return studentRepository.searchByName("%"+searchName+"%");
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Student student) {
        Student newStudent = studentRepository.save(student);
         if (newStudent!=null){
             return  true;
         }
         return false;
    }
}
