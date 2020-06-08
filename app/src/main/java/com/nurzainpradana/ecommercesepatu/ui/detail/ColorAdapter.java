package com.nurzainpradana.ecommercesepatu.ui.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.ColorsModel;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;

import java.util.List;

class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private List<ColorsModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public ColorAdapter(List<ColorsModel> listData, ItemAdapterCallback mItemAdapterCallback) {
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_colors, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data
        holder.ivColors.setImageResource(rvData.get(position).getColors());
        holder.ivColors.setOnClickListener(new View.OnClickListener() {
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
        public ImageView ivColors;

        public ViewHolder(View v){
            super(v);
            ivColors = v.findViewById(R.id.iv_colors);
        }

    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}