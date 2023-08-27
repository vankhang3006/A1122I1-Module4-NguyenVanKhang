package com.example.ktmodule4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String peopleAmount;
    @OneToMany(mappedBy = "type")
    private List<Stadium> stadiums;

    public Type() {
    }

    public Type(int id, String peopleAmount) {
        this.id = id;
        this.peopleAmount = peopleAmount;
    }

    public Type(int id, String peopleAmount, List<Stadium> stadiums) {
        this.id = id;
        this.peopleAmount = peopleAmount;
        this.stadiums = stadiums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(String peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
