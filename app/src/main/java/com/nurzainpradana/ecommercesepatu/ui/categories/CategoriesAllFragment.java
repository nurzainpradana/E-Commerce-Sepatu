package com.nurzainpradana.ecommercesepatu.ui.categories;

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

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.CategoriesModel;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAllFragment extends Fragment implements CategoriesAdapter.ItemAdapterCallback{

    private RecyclerView rvCategories;
    private List<CategoriesModel> categoriesModelList;

    private RecyclerView rvShoes;
    private List<HomeModel> shoesModelList;

    public CategoriesAllFragment() {
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
        return inflater.inflate(R.layout.fragment_categories_all, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCategories = view.findViewById(R.id.rv_categories);
        rvShoes = view.findViewById(R.id.rv_shoes);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        categoriesModelList = new ArrayList<>();
        categoriesModelList.add(new CategoriesModel(1, "All"));
        categoriesModelList.add(new CategoriesModel(2, "Sport"));
        categoriesModelList.add(new CategoriesModel(3, "Casual"));

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categoriesModelList, this);
        rvCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCategories.setAdapter(categoriesAdapter);

        shoesModelList = new ArrayList<>();
        shoesModelList.add(new HomeModel(1, "Ariel", "New", "30%", "A"));
        shoesModelList.add(new HomeModel(2, "Ariel", "New", "30%", "A"));
        shoesModelList.add(new HomeModel(3, "Ariel", "New", "30%", "A"));

        ShoesAdapter shoesAdapter = new ShoesAdapter(shoesModelList);
        rvShoes.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvShoes.setAdapter(shoesAdapter);

    }

    @Override
    public void onClick(View view) {

    }
}