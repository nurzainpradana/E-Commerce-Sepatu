package com.nurzainpradana.ecommercesepatu.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.home.Casual;

import java.util.List;

public class CasualAdapter extends RecyclerView.Adapter<CasualAdapter.ViewHolder> {

    private List<Casual> rvData;
    private ItemAdapterCallback itemAdapterCallback;
    private Context context;

    public CasualAdapter(List<Casual> listData, ItemAdapterCallback mItemAdapterCallback) {
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public CasualAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CasualAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data
        holder.tvDiskon.setText(rvData.get(position).getDisc());
        Glide.with(context).load(rvData.get(position).getPoster()).into(holder.ivPoster);
        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemAdapterCallback.onClickCasual(v, rvData.get(position));
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
        void onClickCasual(View view, Casual casual);
    }
}