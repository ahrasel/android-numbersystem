package com.ahrasel.numbersystems.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.ahrasel.numbersystems.Models.Base.BaseConverter;
import com.ahrasel.numbersystems.Models.Base.Binary;
import com.ahrasel.numbersystems.Models.Base.Decimal;
import com.ahrasel.numbersystems.Models.Base.HexaDecimal;
import com.ahrasel.numbersystems.Models.Base.Octal;
import com.ahrasel.numbersystems.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.ahrasel.numbersystems.Models.Converter.BaseConverter.toAnyBase;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberCalculatioFM extends Fragment {

    @BindView(R.id.number_Option_spinner) Spinner _numberOptionSpinner;
    @BindView(R.id.input_textview) TextView _firstInputTV;
    @BindView(R.id.secondInputTV) TextView _secondInputTV;
    @BindView(R.id.decimal_ouput_TV) TextView _decimalTV;
    @BindView(R.id.binary_ouput_TV) TextView _binaryTV;
    @BindView(R.id.octal_ouput_TV) TextView _octalTV;
    @BindView(R.id.hexa_ouput_TV) TextView _hexaTV;
    @BindView(R.id._0) Button _0;
    @BindView(R.id._1) Button _1;
    @BindView(R.id._2) Button _2;
    @BindView(R.id._3) Button _3;
    @BindView(R.id._4) Button _4;
    @BindView(R.id._5) Button _5;
    @BindView(R.id._6) Button _6;
    @BindView(R.id._7) Button _7;
    @BindView(R.id._8) Button _8;
    @BindView(R.id._9) Button _9;
    @BindView(R.id._A) Button _A;
    @BindView(R.id._B) Button _B;
    @BindView(R.id._C) Button _C;
    @BindView(R.id._D) Button _D;
    @BindView(R.id._E) Button _E;
    @BindView(R.id._F) Button _F;
    @BindView(R.id.devideButton) Button deviceButton;
    @BindView(R.id.multiplyButton) Button multiButton;
    @BindView(R.id.minusButton) Button minusButton;
    @BindView(R.id.plusButton) Button plusButton;

    private Context contex;
    private BaseConverter baseConverter;
    private String firstNumber;
    private String secondNumber;
    String symbol="";

    public NumberCalculatioFM() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.contex = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_calculatio_fm, container, false);
        ButterKnife.bind(this,view);
        createObjectinstance();

        loadSpinner();

        //spinner event
        _numberOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clearAllTextview();
                changeButtonVisibility(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void createObjectinstance() {

    }

    private void changeButtonVisibility(int position) {
        resetAllButtonview();
        if (position == 0){ //Decimal
            _A.setClickable(false);
            _B.setClickable(false);
            _C.setClickable(false);
            _D.setClickable(false);
            _E.setClickable(false);
            _F.setClickable(false);
        }
        if (position == 1){ //Binary
            _2.setClickable(false);
            _3.setClickable(false);
            _4.setClickable(false);
            _5.setClickable(false);
            _6.setClickable(false);
            _7.setClickable(false);
            _8.setClickable(false);
            _9.setClickable(false);
            _A.setClickable(false);
            _B.setClickable(false);
            _C.setClickable(false);
            _D.setClickable(false);
            _E.setClickable(false);
            _F.setClickable(false);
        }
        if (position == 2){ //Octal
            _8.setClickable(false);
            _9.setClickable(false);
            _A.setClickable(false);
            _B.setClickable(false);
            _C.setClickable(false);
            _D.setClickable(false);
            _E.setClickable(false);
            _F.setClickable(false);
        }
        if (position == 3){ //Hexa
        }
    }

    private void resetAllButtonview() {
        _0.setClickable(true);
        _1.setClickable(true);
        _2.setClickable(true);
        _3.setClickable(true);
        _4.setClickable(true);
        _5.setClickable(true);
        _6.setClickable(true);
        _7.setClickable(true);
        _8.setClickable(true);
        _9.setClickable(true);
        _A.setClickable(true);
        _B.setClickable(true);
        _C.setClickable(true);
        _D.setClickable(true);
        _E.setClickable(true);
        _F.setClickable(true);
    }

    private void loadSpinner() {
        ArrayList<String> unitArray =new ArrayList<String>();

        unitArray.add("Decimal");
        unitArray.add("Binary");
        unitArray.add("Octal");
        unitArray.add("HexaDecimal");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                contex, android.R.layout.simple_spinner_dropdown_item, unitArray );

        _numberOptionSpinner.setAdapter(spinnerArrayAdapter);
    }

    private void clearAllTextview() {
        _firstInputTV.setText("");
        _secondInputTV.setText("");
        _decimalTV.setText("");
        _binaryTV.setText("");
        _octalTV.setText("");
        _hexaTV.setText("");
        disableOparationButton(true);
    }

    @OnClick({
            R.id._0,
            R.id._1,
            R.id._2,
            R.id._3,
            R.id._4,
            R.id._5,
            R.id._6,
            R.id._7,
            R.id._8,
            R.id._9,
            R.id._A,
            R.id._B,
            R.id._C,
            R.id._D,
            R.id._E,
            R.id._F,
    })
    public void onNumberButtonClick(View view){
        String val = _firstInputTV.getText().toString();
        switch (view.getId()){
            case R.id._0: val = val+"0"; break;
            case R.id._1: val = val+"1"; break;
            case R.id._2: val = val+"2"; break;
            case R.id._3: val = val+"3"; break;
            case R.id._4: val = val+"4"; break;
            case R.id._5: val = val+"5"; break;
            case R.id._6: val = val+"6"; break;
            case R.id._7: val = val+"7"; break;
            case R.id._8: val = val+"8"; break;
            case R.id._9: val = val+"9"; break;
            case R.id._A: val = val+"A"; break;
            case R.id._B: val = val+"B"; break;
            case R.id._C: val = val+"C"; break;
            case R.id._D: val = val+"D"; break;
            case R.id._E: val = val+"E"; break;
            case R.id._F: val = val+"F"; break;
            default: break;
        }

        _firstInputTV.setText(val);
        //showOutput();
    }

    @OnClick({
            R.id.devideButton,
            R.id.multiplyButton,
            R.id.minusButton,
            R.id.plusButton
    })
    public void arthemeticButtonClick(View view){
        firstNumber = _firstInputTV.getText().toString();
        if (firstNumber.isEmpty()){
            return;
        }
        switch (view.getId()){
            case R.id.devideButton: symbol = "/"; _0.setClickable(false); break;
            case R.id.multiplyButton: symbol = "*"; break;
            case R.id.minusButton: symbol = "-"; break;
            case R.id.plusButton: symbol = "+"; break;
        }

        _secondInputTV.setText(firstNumber+symbol);
        _firstInputTV.setText("");
        //disable all calculation button until equal calculation complete
        disableOparationButton(false);
    }

    private void disableOparationButton(boolean status) {
        deviceButton.setClickable(status);
        multiButton.setClickable(status);
        minusButton.setClickable(status);
        plusButton.setClickable(status);
    }

    @OnClick({
            R.id.clearButton,
            R.id.deleteButton
    })
    public void onClearAndDeleteButtonClick(View view){
        switch (view.getId()){
            case R.id.clearButton: clearAllTextview(); break;
            case R.id.deleteButton: deleteButton(); break;
            default: break;
        }
    }

    private void deleteButton() {
        String val = _firstInputTV.getText().toString();
        if (val.length()>0 && !val.isEmpty()){
            val = val.substring(0,val.length()-1);
            _firstInputTV.setText(val);
        }
        else {
            clearAllTextview();
        }
    }

    @OnClick(R.id.equal_button)
    public void equalButtonClicked(View view){
        if (_firstInputTV.getText().toString().isEmpty() ||
                _secondInputTV.getText().toString().isEmpty()){
            return;
        }
        secondNumber = _firstInputTV.getText().toString();

        showOutput();
    }

    private void showOutput() {
        String result ="0";
        int base = _numberOptionSpinner.getSelectedItemPosition();

        if (base == 0){
            baseConverter = new Decimal();
            result = calculateNumber(10);
        }
        if (base == 1){
            baseConverter = new Binary();
            result = calculateNumber(2);
        }
        if (base == 2){
            baseConverter = new Octal();
            result = calculateNumber(8);
        }
        if (base == 3){
            baseConverter = new HexaDecimal();
            result = calculateNumber(16);
        }



        _decimalTV.setText(baseConverter.toDecimal(result));
        _binaryTV.setText(baseConverter.toBinary(result));
        _octalTV.setText(baseConverter.toOctal(result));
        _hexaTV.setText(baseConverter.toHexaDecimal(result));

        disableOparationButton(true);
        _firstInputTV.setText("");
        _secondInputTV.setText("");
        firstNumber="";
        secondNumber= "";
    }

    private String calculateNumber(int inputBase) {
        firstNumber = baseConverter.toDecimal(firstNumber);
        secondNumber = baseConverter.toDecimal(secondNumber);
        String result = "";
        if (symbol.equals("/")){result = String.valueOf(Long.parseLong(firstNumber) / Long.parseLong(secondNumber));}
        if (symbol.equals("*")){result = String.valueOf(Long.parseLong(firstNumber) * Long.parseLong(secondNumber));}
        if (symbol.equals("-")){result = String.valueOf(Long.parseLong(firstNumber) - Long.parseLong(secondNumber));}
        if (symbol.equals("+")){result = String.valueOf(Long.parseLong(firstNumber) + Long.parseLong(secondNumber));}

          String.valueOf(Long.parseLong(firstNumber) + Long.parseLong(secondNumber));
        return toAnyBase(result,10,inputBase);
    }

}
