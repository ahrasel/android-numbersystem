package com.ahrasel.numbersystems.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahrasel.numbersystems.Models.BcdCode;
import com.ahrasel.numbersystems.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BcdAdapter extends RecyclerView.Adapter<BcdAdapter.BcdViewHolder> {

    private Context context;
    private List<BcdCode> bcdCodes;

    public BcdAdapter(Context context, List<BcdCode> bcdCodes) {
        this.context = context;
        this.bcdCodes = bcdCodes;
    }

    @NonNull
    @Override
    public BcdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.id.bcdcode_itemview,parent,false);
        return new BcdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BcdViewHolder holder, int position) {
        holder.bcdDecimal.setText(bcdCodes.get(position).getBcdDecimal());
        holder.bcd_8421.setText(bcdCodes.get(position).getBcd_8421());
        holder.bcd_7421.setText(bcdCodes.get(position).getBcd_7421());
        holder.bcd_5421.setText(bcdCodes.get(position).getBcd_5421());
        holder.bcd_2421.setText(bcdCodes.get(position).getBcd_2421());
        holder.bcd_6421.setText(bcdCodes.get(position).getBcd_6421_3());
    }

    @Override
    public int getItemCount() {
        return bcdCodes.size();
    }

    public class BcdViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bcd_decimal) TextView bcdDecimal;
        @BindView(R.id.bcd_8421) TextView bcd_8421;
        @BindView(R.id.bcd_7421) TextView bcd_7421;
        @BindView(R.id.bcd_5421) TextView bcd_5421;
        @BindView(R.id.bcd_2421) TextView bcd_2421;
        @BindView(R.id.bcd_642_3) TextView bcd_6421;

        public BcdViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
