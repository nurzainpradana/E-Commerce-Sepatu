package com.nurzainpradana.ecommercesepatu.model.home;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("sport")
    @Expose
    private List<Sport> sport = null;
    @SerializedName("casual")
    @Expose
    private List<Casual> casual = null;

    public List<Sport> getSport() {
        return sport;
    }

    public void setSport(List<Sport> sport) {
        this.sport = sport;
    }

    public List<Casual> getCasual() {
        return casual;
    }

    public void setCasual(List<Casual> casual) {
        this.casual = casual;
    }

}