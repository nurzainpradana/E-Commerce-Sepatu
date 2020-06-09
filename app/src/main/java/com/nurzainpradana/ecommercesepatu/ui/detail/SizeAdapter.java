package com.nurzainpradana.ecommercesepatu.ui.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.ColorsModel;
import com.nurzainpradana.ecommercesepatu.model.SizeModel;

import java.util.List;

class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {

    private List<SizeModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public SizeAdapter(List<SizeModel> listData, ItemAdapterCallback mItemAdapterCallback) {
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public SizeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_size, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SizeAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data

        holder.ivSize.setText(rvData.get(position).getLabels() );
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ivSize;

        public ViewHolder(View v){
            super(v);
            ivSize = v.findViewById(R.id.tv_size);
        }

    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}