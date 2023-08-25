package com.example.ktmodule4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rentTypes")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String timeRange;
    private long price;
    @OneToMany(targetEntity = Stadium.class)
    private List<Stadium> stadiums;

    public RentType() {
    }

    public RentType(int id, String timeRange, long price) {
        this.id = id;
        this.timeRange = timeRange;
        this.price = price;
    }

    public RentType(int id, String timeRange, long price, List<Stadium> stadiums) {
        this.id = id;
        this.timeRange = timeRange;
        this.price = price;
        this.stadiums = stadiums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
