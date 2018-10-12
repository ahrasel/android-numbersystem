package com.ahrasel.numbersystems.Models.Converter;

public class BaseConverter {
    public static String toAnyBase(String val, int fromBase, int toBase) {
        return Long.toString(Long.parseLong(val, fromBase), toBase).toUpperCase();
    }
}
