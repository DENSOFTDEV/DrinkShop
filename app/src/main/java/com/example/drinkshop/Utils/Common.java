package com.example.drinkshop.Utils;

import com.example.drinkshop.Database.DataSource.CartRepository;
import com.example.drinkshop.Database.Local.CartDatabase;
import com.example.drinkshop.Retrofit.IDrinkShopAPI;
import com.example.drinkshop.Retrofit.RetrofitClient;
import com.example.drinkshop.model.Category;
import com.example.drinkshop.model.Drink;
import com.example.drinkshop.model.User;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public   static  final String BASE_URL = "https://densoftdevelopers.com/drinkshop/";

    public static final String  TOPPING_MENU_ID = "7";

    public  static User currentUser = null;

    public static Category currentCategory = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingprice = 0.0;
    public static  List<String> toppingAdded = new ArrayList<>();

    //Hold field
    public static int sizeofcup = -1; //-1 : no chose(error), 0: M , 1 : L
    public static int sugar = -1; //-1 ; no choose (error)
    public static int ice = -1; //

    //Database

    public static CartDatabase cartDatabase;
    public static CartRepository cartRepository;

    public static IDrinkShopAPI getApi()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
