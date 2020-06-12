package com.nurzainpradana.ecommercesepatu.ui.cart;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nurzainpradana.ecommercesepatu.BuildConfig;
import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.api.ApiService;
import com.nurzainpradana.ecommercesepatu.model.cost.ItemCost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShippingFragment extends Fragment {
    private Button btnPayment;
    private ProgressDialog progressDialog;

    public ShippingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shipping, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPayment = view.findViewById(R.id.btn_go_to_payment);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Please Wait ...");
                progressDialog.show();

                getCost("62", "63", "1500", "jne", getView());

            }
        });
    }

    private void getCost(String origin, String destination, String weight, String courier, final View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.RAJA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<ItemCost> call = service.getCost(
                BuildConfig.RAJA_KEY,
                BuildConfig.RAJA_ANDROID,
                origin,
                destination,
                weight,
                courier
        );

        call.enqueue(new Callback<ItemCost>() {
            @Override
            public void onResponse(Call<ItemCost> call, Response<ItemCost> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    int statusCode = response.body().getRajaongkir().getStatus().getCode();
                    if (statusCode == 200) {

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("rajaongkir", response.body().getRajaongkir());
                        Navigation
                                .findNavController(view)
                                .navigate(R.id.action_shippingFragment_to_paymentFragment, bundle);

                    } else {
                        String statusMessage = response.body().getRajaongkir().getStatus().getDescription();
                        Toast.makeText(getActivity(), statusMessage, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Error Retrieve Data From Server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ItemCost> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}