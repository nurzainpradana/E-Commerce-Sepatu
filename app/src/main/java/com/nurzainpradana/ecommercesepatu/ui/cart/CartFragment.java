package com.nurzainpradana.ecommercesepatu.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nurzainpradana.ecommercesepatu.R;

public class CartFragment extends Fragment {

    private Button btnCheckout;
    private LinearLayout layoutCartCheckout;
    private LinearLayout layoutEmpty;
    private RelativeLayout layoutCartDetail;

    private CartPreference cartPreference;


    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCheckout = view.findViewById(R.id.btn_checkout);

        layoutCartDetail = view.findViewById(R.id.layout_cart_detail);
        layoutCartCheckout = view.findViewById(R.id.layout_cart_checkout);
        layoutEmpty = view.findViewById(R.id.layout_empty);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cartPreference = new CartPreference(getContext());
        if (cartPreference.getSpId().isEmpty()) {
            layoutEmpty.setVisibility(View.VISIBLE);
            layoutCartDetail.setVisibility(View.GONE);
            layoutCartCheckout.setVisibility(View.GONE);
        }

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_cartFragment_to_shippingFragment);
            }
        });
    }
}