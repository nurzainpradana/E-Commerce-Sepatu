package com.nurzainpradana.ecommercesepatu.api;

import com.nurzainpradana.ecommercesepatu.model.cost.ItemCost;
import com.nurzainpradana.ecommercesepatu.model.home.ItemProdukResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @GET("https://api.bagicode.com/Ecom/shop.php")
    Call<ItemProdukResponse> getProduct(
            //parameter pakai query
            @Query("code_apps") String code_apps
    );
}