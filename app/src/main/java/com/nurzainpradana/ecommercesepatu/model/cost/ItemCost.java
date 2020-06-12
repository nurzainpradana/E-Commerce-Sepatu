package com.nurzainpradana.ecommercesepatu.model.cost;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemCost implements Parcelable {

    @SerializedName("rajaongkir")
    @Expose
    private Rajaongkir rajaongkir;

    protected ItemCost(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemCost> CREATOR = new Creator<ItemCost>() {
        @Override
        public ItemCost createFromParcel(Parcel in) {
            return new ItemCost(in);
        }

        @Override
        public ItemCost[] newArray(int size) {
            return new ItemCost[size];
        }
    };

    public Rajaongkir getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(Rajaongkir rajaongkir) {
        this.rajaongkir = rajaongkir;
    }

}
