package com.nurzainpradana.ecommercesepatu.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.ui.cart.CartActivity;
import com.nurzainpradana.ecommercesepatu.ui.categories.CategoriesActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View viewToolbar = findViewById(R.id.layout_toolbar);
        ImageView menuCart = viewToolbar.findViewById(R.id.menu_cart);
        ImageView menuFilter = viewToolbar.findViewById(R.id.menu_filter);

        menuCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCart = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(goToCart);
            }
        });

        menuFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCart = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(goToCart);
            }
        });

    }
}