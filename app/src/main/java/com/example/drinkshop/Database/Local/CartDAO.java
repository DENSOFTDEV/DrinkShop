package com.example.drinkshop.Database.Local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.drinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableAmb;

@Dao
public interface CartDAO {

    @Query("SELECT * FROM CART")
    Flowable<List<Cart>> getCartItems();


    @Query("SELECT * FROM CART WHERE id =:cartItemId")
    Flowable<List<Cart>> getCartItemsById(int cartItemId);


    @Query("SELECT COUNT(*) from Cart")
    int countCartItems();

    @Query("DELETE FROM Cart")
    void emptyCart();

    @Insert
    void insertToCart(Cart...carts);

    @Update
    void updatecart(Cart...carts);

    @Delete
    void deletecartItem(Cart cart);



}
