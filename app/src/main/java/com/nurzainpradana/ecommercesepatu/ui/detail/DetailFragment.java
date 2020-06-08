package com.nurzainpradana.ecommercesepatu.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.ColorsModel;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment implements ColorAdapter.ItemAdapterCallback {

    private RecyclerView rvColors;
    private List<ColorsModel> colorsModelList;

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        colorsModelList = new ArrayList<>();
        colorsModelList.add(new ColorsModel(1, R.color.colorAccent));
        colorsModelList.add(new ColorsModel(2, R.color.colorGrey));
        colorsModelList.add(new ColorsModel(3, R.color.colorPrimary));

        ColorAdapter colorAdapter = new ColorAdapter(colorsModelList, this);

        rvColors.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvColors.setAdapter(colorAdapter);

    }

    @Override
    public void onClick(View view) {

    }
}