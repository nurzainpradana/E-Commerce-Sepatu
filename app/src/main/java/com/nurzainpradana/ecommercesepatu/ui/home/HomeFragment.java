package com.nurzainpradana.ecommercesepatu.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;
import com.nurzainpradana.ecommercesepatu.ui.categories.CategoriesActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeAdapter.ItemAdapterCallback {

    private RecyclerView rvSport;
    private RecyclerView rvCasual;
    private List<HomeModel> listData;

    private TextView tvActionLayoutSport;
    private TextView tvActionLayoutCasual;
    private TextView tvHeaderLayoutCasual;
    private TextView tvShopNow;
    private ImageView ivShopNow;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSport = view.findViewById(R.id.rv_sport);
        rvCasual = view.findViewById(R.id.rv_casual);

        View headerLayoutSport =  view.findViewById(R.id.layout_header_sport);
        View headerLayoutCasual =  view.findViewById(R.id.layout_header_casual);
        View headerLayout =  view.findViewById(R.id.layout_header);

        tvActionLayoutSport = headerLayoutSport.findViewById(R.id.tv_action);
        tvActionLayoutCasual = headerLayoutCasual.findViewById(R.id.tv_action);
        tvHeaderLayoutCasual = headerLayoutCasual.findViewById(R.id.tv_title);

        tvShopNow = headerLayout.findViewById(R.id.tv_title);
        ivShopNow = headerLayout.findViewById(R.id.iv_show_now);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Contoh datanya
        listData = new ArrayList<>();
        listData.add(new HomeModel(1, "Ariel", "New", "30%", "url"));
        listData.add(new HomeModel(2, "Ariel", "New", "30%", "url"));
        listData.add(new HomeModel(3, "Ariel", "New", "30%", "url"));
        listData.add(new HomeModel(4, "Ariel", "New", "30%", "url"));
        listData.add(new HomeModel(5, "Ariel", "New", "30%", "url"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        HomeAdapter homeAdapter = new HomeAdapter(listData, this);
        rvSport.setLayoutManager(linearLayoutManager);
        rvSport.setAdapter(homeAdapter);

        tvHeaderLayoutCasual.setText("Casual Shoes");
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        HomeAdapter homeAdapter1 = new HomeAdapter(listData, this);
        rvCasual.setLayoutManager(linearLayoutManager1);
        rvCasual.setAdapter(homeAdapter1);

        tvShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCategories = new Intent(getActivity(), CategoriesActivity.class);
                startActivity(goToCategories);
            }
        });

        ivShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCategories = new Intent(getActivity(), CategoriesActivity.class);
                startActivity(goToCategories);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailFragment);
    }
}