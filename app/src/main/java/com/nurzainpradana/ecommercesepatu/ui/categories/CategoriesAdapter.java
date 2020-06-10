package com.nurzainpradana.ecommercesepatu.ui.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.CategoriesModel;

import java.util.List;

class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<CategoriesModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public CategoriesAdapter(List<CategoriesModel> listData, ItemAdapterCallback mItemAdapterCallback) {
        rvData = listData;
        itemAdapterCallback = mItemAdapterCallback;
    }
    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data

        holder.tvLabel.setText(rvData.get(position).getLabels() );
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvLabel;

        public ViewHolder(View v){
            super(v);
            tvLabel = v.findViewById(R.id.tv_label);
        }

    }

    public interface ItemAdapterCallback {
        void onClick(View view);
    }
}