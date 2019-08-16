package com.example.drinkshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drinkshop.DrinkActivity;
import com.example.drinkshop.Interface.ItemClickListener;
import com.example.drinkshop.R;
import com.example.drinkshop.Utils.Common;
import com.example.drinkshop.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout,null);

        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int i) {
        Picasso.with(context)
                .load(categories.get(i).Link)
                .into(categoryViewHolder.img_product);

        categoryViewHolder.text_menu_name.setText(categories.get(i).Name);

        //event
        categoryViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v) {

                Common.currentCategory = categories.get(i);

                //start a new activity
                context.startActivity(new Intent(context, DrinkActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
