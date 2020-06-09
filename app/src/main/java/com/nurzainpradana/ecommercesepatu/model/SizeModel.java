package com.nurzainpradana.ecommercesepatu.model;

public class SizeModel {
    private int id;
    private String labels;

    public SizeModel(int id, String labels) {
        this.id = id;
        this.labels = labels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
