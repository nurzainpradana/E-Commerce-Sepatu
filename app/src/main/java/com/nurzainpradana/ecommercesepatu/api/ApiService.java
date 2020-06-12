package com.nurzainpradana.ecommercesepatu.api;

import com.nurzainpradana.ecommercesepatu.model.cost.ItemCost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("https://api.rajaongkir.com/starter/cost")
    Call<ItemCost> getCost(
            @Field("key") String token,
            @Field("android-key") String android,
            @Field("origin") String origin,
            @Field("destination") String destination,
            @Field("weight") String weight,
            @Field("courier") String courier
    );
}
