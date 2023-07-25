package com.codegym.ss6_bai1.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjectSet")
    private Set<Student> studentSet;
}
