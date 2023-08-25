package com.example.ktmodule4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(targetEntity = Stadium.class)
    private List<Stadium> stadiums;

    public Area() {
    }

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Area(int id, String name, List<Stadium> stadiums) {
        this.id = id;
        this.name = name;
        this.stadiums = stadiums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
