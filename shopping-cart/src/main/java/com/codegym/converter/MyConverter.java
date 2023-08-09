package com.codegym.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.DecimalFormat;

public class MyConverter implements Converter<Long, String> {
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");


    @Override
    public String convert(Long source) {
        return decimalFormat.format(source);
    }

}
