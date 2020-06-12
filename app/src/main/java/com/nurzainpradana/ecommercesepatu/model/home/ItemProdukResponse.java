package com.nurzainpradana.ecommercesepatu.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemProdukResponse {

    @SerializedName("codeStatus")
    @Expose
    private String codeStatus;
    @SerializedName("codeMessage")
    @Expose
    private String codeMessage;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}