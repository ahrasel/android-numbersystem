package com.ahrasel.numbersystems.Models.Base;

public class Binary implements BaseConverter {
    @Override
    public String toDecimal(String value) {
        return Long.toString(Long.parseLong(value, 2),10);
    }

    @Override
    public String toBinary(String value) {
        return value;
    }

    @Override
    public String toOctal(String value) {
        return Long.toString(Long.parseLong(value, 2),8);
    }

    @Override
    public String toHexaDecimal(String value) {
        return Long.toString(Long.parseLong(value, 2),16).toUpperCase();
    }
}
