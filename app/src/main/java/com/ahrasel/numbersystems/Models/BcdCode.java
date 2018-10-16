package com.ahrasel.numbersystems.Models;

public class BcdCode {
    private String bcdDecimal;
    private String bcd_8421;
    private String bcd_7421;
    private String bcd_5421;
    private String bcd_2421;
    private String bcd_6421_3;

    public BcdCode(String bcdDecimal, String bcd_8421, String bcd_7421, String bcd_5421, String bcd_2421, String bcd_6421_3) {
        this.bcdDecimal = bcdDecimal;
        this.bcd_8421 = bcd_8421;
        this.bcd_7421 = bcd_7421;
        this.bcd_5421 = bcd_5421;
        this.bcd_2421 = bcd_2421;
        this.bcd_6421_3 = bcd_6421_3;
    }

    public String getBcdDecimal() {
        return bcdDecimal;
    }

    public void setBcdDecimal(String bcdDecimal) {
        this.bcdDecimal = bcdDecimal;
    }

    public String getBcd_8421() {
        return bcd_8421;
    }

    public void setBcd_8421(String bcd_8421) {
        this.bcd_8421 = bcd_8421;
    }

    public String getBcd_7421() {
        return bcd_7421;
    }

    public void setBcd_7421(String bcd_7421) {
        this.bcd_7421 = bcd_7421;
    }

    public String getBcd_5421() {
        return bcd_5421;
    }

    public void setBcd_5421(String bcd_5421) {
        this.bcd_5421 = bcd_5421;
    }

    public String getBcd_2421() {
        return bcd_2421;
    }

    public void setBcd_2421(String bcd_2421) {
        this.bcd_2421 = bcd_2421;
    }

    public String getBcd_6421_3() {
        return bcd_6421_3;
    }

    public void setBcd_6421_3(String bcd_6421_3) {
        this.bcd_6421_3 = bcd_6421_3;
    }
}
