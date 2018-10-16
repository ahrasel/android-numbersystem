package com.ahrasel.numbersystems.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahrasel.numbersystems.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BcdCodesFM extends Fragment {

    @BindView(R.id.bcd_header_holder_layout) LinearLayout bcdHolder;
    @BindView(R.id.ascii_header_holder_layout) LinearLayout asciiHolder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Context context;

    public BcdCodesFM() {
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
        return view;
    }

    private void controlLayout() {
        asciiHolder.setVisibility(View.GONE);
        bcdHolder.setVisibility(View.VISIBLE);
    }

}
