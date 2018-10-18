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
        bcdCodes.add(new BcdCode("1","0000","0000","0000","0000","0000"));
        bcdCodes.add(new BcdCode("2","0000","0000","0000","0000","0000"));
        bcdCodes.add(new BcdCode("3","0000","0000","0000","0000","0000"));
        bcdCodes.add(new BcdCode("4","0000","0000","0000","0000","0000"));

        return bcdCodes;
    }
}
