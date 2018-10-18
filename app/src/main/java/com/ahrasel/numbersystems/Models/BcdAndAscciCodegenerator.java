package com.ahrasel.numbersystems.Models;

import java.util.ArrayList;

public class BcdAndAscciCodegenerator  {
    private BcdCode bcdCode;
    private AsciiCode asciiCode;

    public BcdAndAscciCodegenerator() {
        this.bcdCode = new BcdCode();
        this.asciiCode = new AsciiCode();
    }

    public ArrayList<BcdCode> getBcdodes(){
        ArrayList<BcdCode> bcdCodes = new ArrayList<BcdCode>();
        bcdCodes.add(new BcdCode("0","0000","0000","0000","0000","0000"));
        bcdCodes.add(new BcdCode("1","0001","0001","0001","0001","0001"));
        bcdCodes.add(new BcdCode("2","0010","0010","0010","0010","0010"));
        bcdCodes.add(new BcdCode("3","0011","0011","0011","0011","0011"));
        bcdCodes.add(new BcdCode("4","0100","0100","0100","0100","0100"));
        bcdCodes.add(new BcdCode("5","0101","0101","0101","0101","0101"));
        bcdCodes.add(new BcdCode("6","0110","0110","1001","0110","0110"));
        bcdCodes.add(new BcdCode("7","0111","0111","1010","0111","0111"));
        bcdCodes.add(new BcdCode("8","1000","1001","1011","1110","1010"));
        bcdCodes.add(new BcdCode("9","1001","1010","1100","1111","1011"));

        return bcdCodes;
    }

    public ArrayList<AsciiCode> getAsciiCodes(){
        ArrayList<AsciiCode> asciiCodes = new ArrayList<AsciiCode>();

        for (int i = 32; i <= 126; i++) {
            String index = String.valueOf(i);
            String decimal = String.valueOf(i);
            String chracter = String.valueOf((char)i);
            asciiCodes.add(new AsciiCode(index,decimal,chracter));
        }

        for (int i = 161; i <= 225; i++) {
            String index = String.valueOf(i);
            String decimal = String.valueOf(i);
            String chracter = String.valueOf((char)i);
            asciiCodes.add(new AsciiCode(index,decimal,chracter));
        }

        return asciiCodes;
    }
}
