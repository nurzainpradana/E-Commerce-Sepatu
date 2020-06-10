package com.nurzainpradana.ecommercesepatu.ui.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurzainpradana.ecommercesepatu.R;
import com.nurzainpradana.ecommercesepatu.model.CategoriesModel;
import com.nurzainpradana.ecommercesepatu.model.HomeModel;

import java.util.List;

class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ViewHolder> {

    private List<HomeModel> rvData;

    public ShoesAdapter(List<HomeModel> listData) {
        rvData = listData;
    }
    @NonNull
    @Override
    public ShoesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort_vertical, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoesAdapter.ViewHolder holder, int position) {
         //Fungsi untuk menampilkan data

        holder.tvDiskon.setText(rvData.get(position).getDiskonProduct());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDiskon ;

        public ViewHolder(View v){
            super(v);
            tvDiskon = v.findViewById(R.id.tv_diskon);
        }

    }
}