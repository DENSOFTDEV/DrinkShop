package com.example.drinkshop.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.drinkshop.Database.ModelDB.Cart;
import com.example.drinkshop.R;
import com.example.drinkshop.Utils.Common;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter  extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.cart_item_layout,viewGroup,false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, final int i) {
        Picasso.with(context)
                .load(cartList.get(i).link)
                .into(cartViewHolder.img_product);

        cartViewHolder.txt_amount.setNumber(String.valueOf(cartList.get(i).amount));
        cartViewHolder.txt_price.setText(new StringBuilder("$").append(cartList.get(i).price));
        cartViewHolder.txt_product_name.setText(cartList.get(i).name);
        cartViewHolder.txt_sugar_ice.setText(new StringBuilder("Sugar")
        .append("Ice: ").append(cartList.get(i).ice)
        .append("%").toString());

        //auto save item on user change amount
        cartViewHolder.txt_amount.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Cart cart = cartList.get(i);
                cart.amount = newValue;

                Common.cartRepository.updatecart(cart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_product;
        TextView txt_product_name, txt_sugar_ice, txt_price;
        ElegantNumberButton txt_amount;



        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            img_product = (ImageView) itemView.findViewById(R.id.img_prdct);
            txt_product_name = (TextView) itemView.findViewById(R.id.txt_product_name);
            txt_sugar_ice = (TextView) itemView.findViewById(R.id.txt_sugar_ice);
            txt_price = (TextView) itemView.findViewById(R.id.txt_price);
            txt_amount = (ElegantNumberButton) itemView.findViewById(R.id.txt_amount);

        }
    }
}
