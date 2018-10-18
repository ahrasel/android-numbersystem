package com.ahrasel.numbersystems.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahrasel.numbersystems.Adapter.AsciiAdapter;
import com.ahrasel.numbersystems.Models.BcdAndAscciCodegenerator;
import com.ahrasel.numbersystems.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsciiCodesFM extends Fragment {


    @BindView(R.id.bcd_header_holder_layout) LinearLayout bcdHolder;
    @BindView(R.id.ascii_header_holder_layout) LinearLayout asciiHolder;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private Context context;

    public AsciiCodesFM() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view_fm, container, false);
        ButterKnife.bind(this,view);
        controlLayout();
        loadRecyclerView();
        return view;
    }

    private void loadRecyclerView() {
        BcdAndAscciCodegenerator codegenerator =  new BcdAndAscciCodegenerator();
        AsciiAdapter asciiAdapter = new AsciiAdapter(context,codegenerator.getAsciiCodes());
        recyclerView.setAdapter(asciiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    private void controlLayout() {
        asciiHolder.setVisibility(View.VISIBLE);
        bcdHolder.setVisibility(View.GONE);
    }

}
