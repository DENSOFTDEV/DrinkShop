package com.example.drinkshop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.drinkshop.R;
import com.example.drinkshop.Utils.Common;
import com.example.drinkshop.model.Drink;

import java.util.List;

public class MultichoiceAdapter extends RecyclerView.Adapter<MultichoiceAdapter.MultichoiceViewHolder> {
    Context context;
    List<Drink> optionList;


    public MultichoiceAdapter(Context context, List<Drink> optionList) {
        this.context = context;
        this.optionList = optionList;
    }

    @NonNull
    @Override
    public MultichoiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.multi_check_layout,null);
        return new  MultichoiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MultichoiceViewHolder multichoiceViewHolder, final int i) {
        multichoiceViewHolder.checkBox.setText(optionList.get(i).Name);
        multichoiceViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Common.toppingAdded.add(buttonView.getText().toString());
                    Common.toppingprice += Double.parseDouble(optionList.get(i).Price);
                }else
                {

                    Common.toppingAdded.remove(buttonView.getText().toString());
                    Common.toppingprice-= Double.parseDouble(optionList.get(i).Price);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    class MultichoiceViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;

        public MultichoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.ckb_topping);
        }
    }
}
