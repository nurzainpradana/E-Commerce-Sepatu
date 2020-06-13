package com.nurzainpradana.ecommercesepatu.ui.detail;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.ColorsModel;
import com.nurzainpradana.ecommercesepatu.model.SizeModel;
import com.nurzainpradana.ecommercesepatu.model.home.Casual;
import com.nurzainpradana.ecommercesepatu.model.home.Sport;
import com.nurzainpradana.ecommercesepatu.ui.cart.CartActivity;
import com.nurzainpradana.ecommercesepatu.utils.Const;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment implements ColorAdapter.ItemAdapterCallback, SizeAdapter.ItemAdapterCallback{

    private RecyclerView rvColors;
    private List<ColorsModel> colorsModelList;

    private RecyclerView rvSize;
    private List<SizeModel> sizeModelList;

    private String dataStatus;
    private Sport dataSport;
    private Casual dataCasual;

    private Button btnAddToCart;



    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvColors = view.findViewById(R.id.rv_colors);
        rvSize = view.findViewById(R.id.rv_size);
        btnAddToCart = view.findViewById(R.id.btn_add_to_cart);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataStatus = getArguments().getString(new Const().INTENT_DETAIL_STATUS);
        if (dataStatus.equalsIgnoreCase(new Const().SPORT)) {
            dataSport = getArguments().getParcelable(new Const().INTENT_DETAIL);
            if (dataSport != null) {
                initView(dataSport);
            }
        } else {
            dataCasual = getArguments().getParcelable(new Const().INTENT_DETAIL);
            if (dataCasual != null) {
                initView(dataCasual);
            }
        }

        colorsModelList = new ArrayList<>();
        colorsModelList.add(new ColorsModel(1, R.color.colorAccent));
        colorsModelList.add(new ColorsModel(2, R.color.colorGrey));
        colorsModelList.add(new ColorsModel(3, R.color.colorPrimary));

        ColorAdapter colorAdapter = new ColorAdapter(colorsModelList, this);

        rvColors.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvColors.setAdapter(colorAdapter);

        sizeModelList = new ArrayList<>();
        sizeModelList.add(new SizeModel(1, "36\nEU"));
        sizeModelList.add(new SizeModel(2, "37\nEU"));
        sizeModelList.add(new SizeModel(3, "38\nEU"));
        sizeModelList.add(new SizeModel(4, "39\nEU"));
        sizeModelList.add(new SizeModel(5, "40\nEU"));
        sizeModelList.add(new SizeModel(6, "41\nEU"));
        sizeModelList.add(new SizeModel(7, "42\nEU"));
        sizeModelList.add(new SizeModel(8, "43\nEU"));


        SizeAdapter sizeAdapter = new SizeAdapter(sizeModelList, this);

        rvSize.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvSize.setAdapter(sizeAdapter);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCart = new Intent(getActivity(), CartActivity.class);
                startActivity(goToCart);
            }
        });

    }

    private void initView(Sport dataSport) {
    }

    private void initView(Casual dataCasual) {
    }

    @Override
    public void onClick(View view) {

    }
}