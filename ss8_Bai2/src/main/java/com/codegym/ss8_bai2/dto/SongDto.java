package com.codegym.ss8_bai2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String singer;
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        //Validate Name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","fields.required", "name cannot empty");
        if (songDto.getName().length() > 800) {
            errors.rejectValue("name","fields.maxLength","Độ dài không được vượt quá 800");
        }
        if (songDto.getName().matches(".*[@;,.=+\\-].*")) {
            errors.rejectValue("name","field.invalidCharacters","Không được chứa kí tự đặc biệt");
        }
        //Validate Singer
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"singer","fields.required", "singer cannot empty");
        if (songDto.getSinger().length() > 300) {
            errors.rejectValue("singer","fields.maxLength","Độ dài không được vượt quá 300");
        }
        if (songDto.getSinger().matches(".*[@;,.=+\\-].*")) {
            errors.rejectValue("singer","field.invalidCharacters","Không được chứa kí tự đặc biệt");
        }
        //Validate Type
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"type","fields.required", "type cannot empty");
        if (songDto.getType().length() > 1000) {
            errors.rejectValue("type", "field.maxLength", "Độ dài không được vượt quá 1000");
        }
        if (songDto.getType().matches(".*[^,a-zA-Z0-9].*")) {
            errors.rejectValue("type", "field.invalidCharacters","Không được chứa kí tự đặc biệt");
        }


    }
}
