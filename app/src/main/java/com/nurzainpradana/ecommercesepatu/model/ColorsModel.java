package com.nurzainpradana.ecommercesepatu.model;

public class ColorsModel {
    private int id;
    private int colors;

    public ColorsModel(int id, int colors) {
        this.id = id;
        this.colors = colors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }
}
