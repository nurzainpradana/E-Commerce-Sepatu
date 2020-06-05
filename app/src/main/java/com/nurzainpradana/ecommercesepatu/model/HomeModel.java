package com.nurzainpradana.ecommercesepatu.model;

public class HomeModel {
    private int idProduct;
    private String namaProduct;
    private String statusProduct;
    private String diskonProduct;
    private String imageProduct;

    public HomeModel(int idProduct, String namaProduct, String statusProduct, String diskonProduct, String imageProduct) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.statusProduct = statusProduct;
        this.diskonProduct = diskonProduct;
        this.imageProduct = imageProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getDiskonProduct() {
        return diskonProduct;
    }

    public void setDiskonProduct(String diskonProduct) {
        this.diskonProduct = diskonProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
