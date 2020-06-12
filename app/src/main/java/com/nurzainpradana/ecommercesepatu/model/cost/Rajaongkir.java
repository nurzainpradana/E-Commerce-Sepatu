package com.nurzainpradana.ecommercesepatu.model.cost;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rajaongkir implements Parcelable {

    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("origin_details")
    @Expose
    private OriginDetails originDetails;
    @SerializedName("destination_details")
    @Expose
    private DestinationDetails destinationDetails;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    protected Rajaongkir(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Rajaongkir> CREATOR = new Creator<Rajaongkir>() {
        @Override
        public Rajaongkir createFromParcel(Parcel in) {
            return new Rajaongkir(in);
        }

        @Override
        public Rajaongkir[] newArray(int size) {
            return new Rajaongkir[size];
        }
    };

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OriginDetails getOriginDetails() {
        return originDetails;
    }

    public void setOriginDetails(OriginDetails originDetails) {
        this.originDetails = originDetails;
    }

    public DestinationDetails getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(DestinationDetails destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
