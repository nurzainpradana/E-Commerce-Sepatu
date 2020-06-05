package com.nurzainpradana.ecommercesepatu.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;

import java.util.List;

class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public HomeAdapter(List<HomeModel> listData, ItemAdapterCallback mItemAdapterCallback) {
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data
        holder.tvDiskon.setText(rvData.get(position).getDiskonProduct());
        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemAdapterCallback.onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPoster;
        public TextView tvDiskon;

        public ViewHolder(View v){
            super(v);

            tvDiskon = v.findViewById(R.id.tv_diskon);
            ivPoster = v.findViewById(R.id.iv_poster);
        }

    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}