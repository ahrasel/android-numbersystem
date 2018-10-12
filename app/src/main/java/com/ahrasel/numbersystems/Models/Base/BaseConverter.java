package com.ahrasel.numbersystems.Models.Base;

public interface BaseConverter {
    String toDecimal(String value);
    String toBinary(String value);
    String toOctal(String value);

    /**
     * @param value Accept String number
     * @return String Hexadecimal Value
     */
    String toHexaDecimal(String value);
}
