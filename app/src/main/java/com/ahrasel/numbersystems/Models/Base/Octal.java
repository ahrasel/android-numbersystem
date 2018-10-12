package com.ahrasel.numbersystems.Models.Base;

public class Octal implements BaseConverter {

    @Override
    public String toDecimal(String value) {
        return Long.toString(Long.parseLong(value, 8),10);
    }

    @Override
    public String toBinary(String value) {
        return Long.toString(Long.parseLong(value, 8),2);

    }

    @Override
    public String toOctal(String value) {
        return value;
    }

    @Override
    public String toHexaDecimal(String value) {
        return Long.toString(Long.parseLong(value, 8),16).toUpperCase();

    }
}
