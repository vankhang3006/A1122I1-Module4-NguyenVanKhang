package com.example.ktmodule4.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtils {
    public static String formatPrice(long price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,### đ");
        return decimalFormat.format(price);
    }
}
