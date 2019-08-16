package com.example.drinkshop.Database.DataSource;

import com.example.drinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;

public interface ICartDataSource {

    Flowable<List<Cart>> getCartItems();
    Flowable<List<Cart>> getCartItemsById(int cartItemId);
    int countCartItems();
    void emptyCart();
    void insertToCart(Cart...carts);
    void updatecart(Cart...carts);
    void deletecartItem(Cart cart);

}
