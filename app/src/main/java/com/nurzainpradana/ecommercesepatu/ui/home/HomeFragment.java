package com.nurzainpradana.ecommercesepatu.ui.home;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.nurzainpradana.ecommercesepatu.BuildConfig;
import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.api.ApiService;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;
import com.nurzainpradana.ecommercesepatu.model.home.Casual;
import com.nurzainpradana.ecommercesepatu.model.home.ItemProdukResponse;
import com.nurzainpradana.ecommercesepatu.model.home.Sport;
import com.nurzainpradana.ecommercesepatu.ui.categories.CategoriesActivity;
import com.nurzainpradana.ecommercesepatu.ui.home.adapter.CasualAdapter;
import com.nurzainpradana.ecommercesepatu.ui.home.adapter.SportAdapter;
import com.nurzainpradana.ecommercesepatu.utils.Const;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment implements SportAdapter.ItemAdapterCallback, CasualAdapter.ItemAdapterCallback {

    private RecyclerView rvSport;
    private RecyclerView rvCasual;
    private List<HomeModel> listData;

    private TextView tvActionLayoutSport;
    private TextView tvActionLayoutCasual;
    private TextView tvHeaderLayoutCasual;
    private TextView tvShopNow;
    private ImageView ivShopNow;

    private ProgressDialog progressDialog;

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

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait ...");
        progressDialog.show();
        getData();
    }



    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SHOP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<ItemProdukResponse> call = service.getProduct(
                new Const().CODE_APPS
        );

        call.enqueue(new Callback<ItemProdukResponse>() {
            @Override
            public void onResponse(Call<ItemProdukResponse> call, Response<ItemProdukResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    String statusCode = response.body().getCodeStatus();
                    if (statusCode.equalsIgnoreCase("200")) {
                        //Fungsi untuk
                        setDataSport(response.body().getData().getSport());
                        setDataCasual(response.body().getData().getCasual());

                    } else {
                        String statusMessage = response.body().getCodeMessage();
                        Toast.makeText(getActivity(), statusMessage, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Error Retrieve Data From Server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ItemProdukResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setDataCasual(List<Casual> casual) {
        tvHeaderLayoutCasual.setText("Casual Shoes");
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        CasualAdapter casualAdapter = new CasualAdapter(casual, this);
        rvCasual.setLayoutManager(linearLayoutManager1);
        rvCasual.setAdapter(casualAdapter);
    }


    private void setDataSport(List<Sport> sport) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        SportAdapter sportAdapter = new SportAdapter(sport, this);
        rvSport.setLayoutManager(linearLayoutManager);
        rvSport.setAdapter(sportAdapter);
    }

    @Override
    public void onClickCasual(View view, Casual casual) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(new Const().INTENT_DETAIL, casual);
        bundle.putString(new Const().INTENT_DETAIL_STATUS, new Const().CASUAL);

        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailFragment, bundle);
    }

    @Override
    public void onClickSport(View view, Sport sport) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(new Const().INTENT_DETAIL, sport);
        bundle.putString(new Const().INTENT_DETAIL_STATUS, new Const().SPORT);

        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_detailFragment, bundle);
    }
}