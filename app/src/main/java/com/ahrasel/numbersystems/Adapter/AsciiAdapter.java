package com.ahrasel.numbersystems.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahrasel.numbersystems.Models.AsciiCode;
import com.ahrasel.numbersystems.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AsciiAdapter extends RecyclerView.Adapter<AsciiAdapter.AsciiViewHolder> {
    private Context context;
    private List<AsciiCode> asciiCodes;

    public AsciiAdapter(Context context, List<AsciiCode> asciiCodes) {
        this.context = context;
        this.asciiCodes = asciiCodes;
    }

    @NonNull
    @Override
    public AsciiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.asciicode_itemview,parent,false);
        return new AsciiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsciiViewHolder holder, int position) {
        holder.asciiOcdeTV.setText(asciiCodes.get(position).getAsciiCode());
        holder.decimalTV.setText(asciiCodes.get(position).getDecimalvalue());
        holder.chracterTV.setText(asciiCodes.get(position).getCharecter());
    }

    @Override
    public int getItemCount() {
        return asciiCodes.size();
    }

    public class AsciiViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ascii_COde_textView) TextView asciiOcdeTV;
        @BindView(R.id.decimal_value_textView) TextView decimalTV;
        @BindView(R.id.charecter_textView) TextView chracterTV;

        public AsciiViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
