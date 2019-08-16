package com.example.drinkshop.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.drinkshop.Database.ModelDB.Cart;
import com.example.drinkshop.Interface.ItemClickListener;
import com.example.drinkshop.R;
import com.example.drinkshop.Utils.Common;
import com.example.drinkshop.model.Drink;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {
    Context context;
    List<Drink> drinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.drink_item_layout,null);

        return new DrinkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder drinkViewHolder, final int i) {

        drinkViewHolder.txt_price.setText(new StringBuilder("$").append(drinkList.get(i).Price).toString());
        drinkViewHolder.txt_drink_name.setText(drinkList.get(i).Name);
        drinkViewHolder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAddToCartDialog(i);
            }
        });

        Picasso.with(context)
                .load(drinkList.get(i).Link)
                .into(drinkViewHolder.img_product);
        drinkViewHolder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ShowAddToCartDialog(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout,null);

        //view
        ImageView img_product_dialog = (ImageView) itemView.findViewById(R.id.img_cart_product);
        final ElegantNumberButton txt_count = (ElegantNumberButton) itemView.findViewById(R.id.txt_count);
        TextView txt_product_dialog = (TextView) itemView.findViewById(R.id.txt_cart_product_name);


        EditText editText = (EditText) itemView.findViewById(R.id.edt_comment);

        RadioButton rdi_sizeM = (RadioButton) itemView.findViewById(R.id.rdi_sizeM);
        RadioButton rdi_sizeL = (RadioButton) itemView.findViewById(R.id.rdi_sizeL);

        rdi_sizeM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeofcup = 0;
            }
        });


        rdi_sizeL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeofcup = 1;
            }
        });

        RadioButton rdi_sugar_100 = (RadioButton) itemView.findViewById(R.id.rdi_sugar_100);
        RadioButton rdi_sugar_70 = (RadioButton) itemView.findViewById(R.id.rdi_sugar_70);
        RadioButton rdi_sugar_50 = (RadioButton) itemView.findViewById(R.id.rdi_sugar_50);
        RadioButton rdi_sugar_30 = (RadioButton) itemView.findViewById(R.id.rdi_sugar_30);
        RadioButton rdi_sugar_free = (RadioButton) itemView.findViewById(R.id.rdi_sugar_free);


        rdi_sugar_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 30;
            }
        });

        rdi_sugar_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 50;
            }
        });

        rdi_sugar_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 70;
            }
        });

        rdi_sugar_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 30;
            }
        });

        rdi_sugar_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 100;
            }
        });

        rdi_sugar_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 0;
            }
        });

        RadioButton rdi_ice_100 = (RadioButton) itemView.findViewById(R.id.rdi_ice_100);
        RadioButton rdi_ice_70 = (RadioButton) itemView.findViewById(R.id.rdi_ice_70);
        RadioButton rdi_ice_50 = (RadioButton) itemView.findViewById(R.id.rdi_ice_50);
        RadioButton rdi_ice_30 = (RadioButton) itemView.findViewById(R.id.rdi_ice_30);
        RadioButton rdi_ice_free = (RadioButton) itemView.findViewById(R.id.rdi_ice_free);

        rdi_ice_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 30;
            }
        });

        rdi_ice_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 50;
            }
        });

        rdi_ice_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice= 70;
            }
        });

        rdi_ice_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 100;
            }
        });

        rdi_ice_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 0;
            }
        });


        RecyclerView recycler_topping = (RecyclerView) itemView.findViewById(R.id.recycler_topping);
        recycler_topping.setLayoutManager(new LinearLayoutManager(context));
        recycler_topping.setHasFixedSize(true);

        MultichoiceAdapter adapter = new MultichoiceAdapter(context, Common.toppingList);
        recycler_topping.setAdapter(adapter);


        //set data

        Picasso.with(context)
                .load(drinkList.get(i).Link)
                .into(img_product_dialog);
        txt_product_dialog.setText(drinkList.get(i).Name);

        builder.setView(itemView);
        builder.setNegativeButton("ADD TO CART", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                if (Common.sizeofcup == -1)
                {
                    Toast.makeText(context, "Please choose size of cup", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Common.sugar == -1 )
                {
                    Toast.makeText(context, "Please choose sugar", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Common.ice == -1 )
                {
                    Toast.makeText(context, "Please choose ice", Toast.LENGTH_SHORT).show();
                    return;
                }
                showConfirmDialog(i,txt_count.getNumber());
               dialog.dismiss();
            }


        });

        builder.show();
    }

    private void showConfirmDialog(final int i, final String number) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.confirm_add_to_cart_layout,null);

        //view
        ImageView img_product_dialog = (ImageView) itemView.findViewById(R.id.img_product);
        final TextView txt_product_dialog = (TextView) itemView.findViewById(R.id.txt_cart_product_name);
        final TextView txt_product_price = (TextView) itemView.findViewById(R.id.txt_cart_product_price);
        TextView txt_sugar = (TextView) itemView.findViewById(R.id.txt_sugar);
        TextView txt_ice = (TextView) itemView.findViewById(R.id.txt_ice);
        final TextView txt_topping_extra = (TextView) itemView.findViewById(R.id.txt_topping_extra);

        //Get data
        Picasso.with(context).load(drinkList.get(i).Link).into(img_product_dialog);
        txt_product_dialog.setText(new StringBuilder(drinkList.get(i).Name).append(" x")
        .append(number)
        .append(Common.sizeofcup == 0 ? "Size M":"Size L" ).toString());


        txt_ice.setText(new StringBuilder("Ice: ").append(Common.ice).append("%").toString());
        txt_sugar.setText(new StringBuilder("Sugar: ").append(Common.sugar).append("%").toString());

        double price = (Double.parseDouble(drinkList.get(i).Price)* Double.parseDouble(number)) + Common.toppingprice;

        if (Common.sizeofcup == 1)
            price+=3.0;

        txt_product_price.setText(new StringBuilder("%").append(price));

        StringBuilder topping_final_comment = new StringBuilder();
        for (String line:Common.toppingAdded)
            topping_final_comment.append(line).append("\n");

        txt_topping_extra.setText(topping_final_comment);

        final double finalPrice = price;
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

                try {

                    //Add to SQLite
                    //Create new Cart item
                    Cart cartItem = new Cart();
                    cartItem.name = txt_product_dialog.getText().toString();
                    cartItem.amount = Integer.parseInt(number);
                    cartItem.ice = Common.ice;
                    cartItem.sugar = Common.sugar;
                    cartItem.price = finalPrice;
                    cartItem.toppingExtras = txt_topping_extra.getText().toString();
                    cartItem.link = drinkList.get(i).Link;
                    //Add to DB

                    Common.cartRepository.insertToCart(cartItem);

                    Log.d("DRINK_DEBUG",new Gson().toJson(cartItem));

                    Toast.makeText(context, "save item to cart success", Toast.LENGTH_SHORT).show();


                } catch (Exception ex)
                {
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        builder.setView(itemView);
        builder.show();

    }


    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
