package com.example.ktmodule4.dto;

import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.model.Type;
import com.example.ktmodule4.service.stadium.IStadiumService;
import com.example.ktmodule4.service.stadium.StadiumService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class StadiumDto implements Validator {
    private int id;
    private String name;
    private String address;
    private Area area;
    private RentType rentType;
    private Type type;

    public StadiumDto() {
    }

    public StadiumDto(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public StadiumDto(int id, String name, String address, Area area, RentType rentType, Type type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.area = area;
        this.rentType = rentType;
        this.type = type;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public void validateNameUnique(IStadiumService stadiumService, Errors errors) {
        if (!stadiumService.isNameUnique(name)) {
            errors.rejectValue("name", "error.stadiumDto", "Tên sân đã tồn tại.");
        }
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
//    @Size(message = "không đúng độ dài quy định",min = 5,max = 45)
//    private String firstName;
//    @Size(message = "không đúng độ dài quy định",min = 5,max = 45)
//    private String lastName;
//    @Pattern(regexp = "0\\d{9}",message = "không đúng định dạng của số điện thoại")
//    private String phoneNumber;
//    @Min(value = 18,message = "Không đủ tuổi quy định")
//    private int age;
//    @Email(message = "Email không hợp lệ")
//    private String email;