package com.example.drinkshop.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drinkshop.Interface.ItemClickListener;
import com.example.drinkshop.R;

public class CategoryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img_product;
    TextView text_menu_name;

    ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        img_product = (ImageView) itemView.findViewById(R.id.image_product);
        text_menu_name = (TextView) itemView.findViewById(R.id.text_menu_name);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v);

    }
}
