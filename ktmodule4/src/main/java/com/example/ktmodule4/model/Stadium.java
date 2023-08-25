package com.example.ktmodule4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "rentType_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    public Stadium() {
    }

    public Stadium(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Stadium(int id, String name, String address, RentType rentType, Type type, Area area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rentType = rentType;
        this.type = type;
        this.area = area;
    }
    @Override
    public String toString() {
        return String.format("Stadium[id=%d, name='%s', address='%s']", id, name, address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
