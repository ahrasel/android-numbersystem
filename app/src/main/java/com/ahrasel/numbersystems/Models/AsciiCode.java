package com.ahrasel.numbersystems.Models;

public class AsciiCode {
    private String asciiCode;
    private String decimalvalue;
    private String charecter;

    public AsciiCode(String asciiCode, String decimalvalue, String charecter) {
        this.asciiCode = asciiCode;
        this.decimalvalue = decimalvalue;
        this.charecter = charecter;
    }

    public AsciiCode() {
    }

    public String getAsciiCode() {
        return asciiCode;
    }

    public void setAsciiCode(String asciiCode) {
        this.asciiCode = asciiCode;
    }

    public String getDecimalvalue() {
        return decimalvalue;
    }

    public void setDecimalvalue(String decimalvalue) {
        this.decimalvalue = decimalvalue;
    }

    public String getCharecter() {
        return charecter;
    }

    public void setCharecter(String charecter) {
        this.charecter = charecter;
    }
}
