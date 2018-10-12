package com.ahrasel.numbersystems.Models.Base;

public class HexaDecimal implements BaseConverter {
    @Override
    public String toDecimal(String value) {
        return Long.toString(Long.parseLong(value, 16),10);

    }

    @Override
    public String toBinary(String value) {
        return Long.toString(Long.parseLong(value, 16),2);
    }

    @Override
    public String toOctal(String value) {
        return Long.toString(Long.parseLong(value, 16),8);
    }

    @Override
    public String toHexaDecimal(String value) {
        return value.toUpperCase();
    }
}
