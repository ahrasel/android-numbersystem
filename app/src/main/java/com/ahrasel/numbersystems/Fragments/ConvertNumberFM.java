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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.ahrasel.numbersystems.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConvertNumberFM extends Fragment {

    @BindView(R.id.number_Option_spinner) Spinner _numberOptionSpinner;
    @BindView(R.id.inputTV) TextView _inputTV;
    @BindView(R.id.decimal_ouput_TV) TextView _decimalTV;
    @BindView(R.id.binary_ouput_TV) TextView _binaryTV;
    @BindView(R.id.octal_ouput_TV) TextView _octalTV;
    @BindView(R.id.hexa_ouput_TV) TextView _hexaTV;
    @BindView(R.id._1s_complement_output_tv) TextView _1sComplement;
    @BindView(R.id._2s_complement_output_tv) TextView _2sComplement;
    @BindView(R.id.binary_extaras_output_layout) LinearLayout _complementOutputContainer;
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

    private Context contex;

    public ConvertNumberFM() {
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
        View view = inflater.inflate(R.layout.fragment_convert_number_fm, container, false);
        ButterKnife.bind(this,view);

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

    private void changeButtonVisibility(int position) {
        resetAllButtonview();
        if (position == 0){ //Decimal
            _complementOutputContainer.setVisibility(View.GONE);
            _A.setClickable(false);
            _B.setClickable(false);
            _C.setClickable(false);
            _D.setClickable(false);
            _E.setClickable(false);
            _F.setClickable(false);
        }
        if (position == 1){ //Binary
            _complementOutputContainer.setVisibility(View.VISIBLE);
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
            _complementOutputContainer.setVisibility(View.GONE);
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
            _complementOutputContainer.setVisibility(View.GONE);
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

    @OnClick({
            R.id.clearButton,
            R.id.deleteButton
    })
    public void onClearAndDeleteButtonClick(View view){
        switch (view.getId()){
            case R.id.clearButton: _inputTV.setText("");break;
            case R.id.deleteButton: deleteButton(); break;
            default: break;
        }
    }

    private void deleteButton() {
        String val = _inputTV.getText().toString();
        if (val.length()>0 && !val.isEmpty()){
            val = val.substring(0,val.length()-1);
            _inputTV.setText(val);
        }
        else {
            clearAllTextview();
        }
    }

    private void clearAllTextview() {
        _inputTV.setText("");
        _decimalTV.setText("");
        _binaryTV.setText("");
        _octalTV.setText("");
        _hexaTV.setText("");
        _1sComplement.setText("");
        _2sComplement.setText("");
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
        String val = _inputTV.getText().toString();
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

        _inputTV.setText(val);
    }

}
