package com.ahrasel.numbersystems.Models.Base;

public class Decimal implements BaseConverter{

    @Override
    public String toDecimal(String value) {
        return value.toString();
    }

    @Override
    public String toBinary(String value) {
        return Long.toString(Long.parseLong(value, 10),2);
    }

    @Override
    public String toOctal(String value) {
        return Long.toString(Long.parseLong(value, 10),8);
    }

    @Override
    public String toHexaDecimal(String value) {
        return Long.toString(Long.parseLong(value, 10),16).toUpperCase();
    }
}
