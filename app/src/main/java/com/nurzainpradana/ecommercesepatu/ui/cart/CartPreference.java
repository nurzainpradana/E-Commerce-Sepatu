package com.nurzainpradana.ecommercesepatu.ui.cart;

import android.content.Context;
import android.content.SharedPreferences;

public class CartPreference {

    public static final String SP_CART = "spCartApp";
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_POSTER = "poster";
    public static final String KEY_PRICE = "price";
    public static final String KEY_PRICE_DISCOUNT = "price_discount";
    public static final String KEY_DISCOUNT = "discount";
    public static final String KEY_DESC = "desc";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public CartPreference(Context context) {
        sp = context.getSharedPreferences("", Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSpString(String key, String value) {
        spEditor.putString(key, value);
        spEditor.commit();
    }

    public void saveSpInteger(String key, Integer value) {
        spEditor.putInt(key, value);
        spEditor.commit();
    }

    public String getSpId() {
        return sp.getString(KEY_ID, "");
    }

    public String getSpTitle() {
        return sp.getString(KEY_TITLE, "");
    }

    public String getSpPoster() {
        return sp.getString(KEY_POSTER, "");
    }

    public String getSpDiscount() {
        return sp.getString(KEY_DISCOUNT, "");
    }

    public String getSpPriceDiscount() {
        return sp.getString(KEY_PRICE_DISCOUNT, "");
    }

    public String getSpPrice() {
        return sp.getString(KEY_PRICE, "");
    }

    public String getSpDesc() {
        return sp.getString(KEY_DESC, "");
    }


}
