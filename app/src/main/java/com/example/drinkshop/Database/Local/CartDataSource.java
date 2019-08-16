package com.example.drinkshop.Database.Local;

import com.example.drinkshop.Database.DataSource.ICartDataSource;
import com.example.drinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;

public class CartDataSource implements ICartDataSource {

    private  CartDAO cartDAO;
    private  static  CartDataSource instance;

    public CartDataSource(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public  static  CartDataSource getInstance(CartDAO cartDAO)
    {
        if (instance == null)
            instance = new CartDataSource(cartDAO);
        return instance;
    }

    @Override
    public Flowable<List<Cart>> getCartItems() {
        return cartDAO.getCartItems();
    }

    @Override
    public Flowable<List<Cart>> getCartItemsById(int cartItemId) {
        return cartDAO.getCartItemsById(cartItemId);
    }

    @Override
    public int countCartItems() {
        return cartDAO.countCartItems();
    }

    @Override
    public void emptyCart() {
        cartDAO.emptyCart();
    }

    @Override
    public void insertToCart(Cart... carts) {
        cartDAO.insertToCart(carts);
    }

    @Override
    public void updatecart(Cart... carts) {
        cartDAO.updatecart(carts);
    }

    @Override
    public void deletecartItem(Cart cart) {
        cartDAO.deletecartItem(cart);
    }
}
