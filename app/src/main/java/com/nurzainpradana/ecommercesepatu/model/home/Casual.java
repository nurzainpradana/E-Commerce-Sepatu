package com.nurzainpradana.ecommercesepatu.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Casual {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("disc")
    @Expose
    private String disc;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("price_promo")
    @Expose
    private String pricePromo;
    @SerializedName("price_real")
    @Expose
    private String priceReal;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPricePromo() {
        return pricePromo;
    }

    public void setPricePromo(String pricePromo) {
        this.pricePromo = pricePromo;
    }

    public String getPriceReal() {
        return priceReal;
    }

    public void setPriceReal(String priceReal) {
        this.priceReal = priceReal;
    }

}