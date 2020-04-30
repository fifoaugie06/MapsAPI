package com.example.mapsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsapi.MapsActivity;
import com.example.mapsapi.R;
import com.example.mapsapi.model.dataHome;

import java.util.ArrayList;


public class CustomHomeAdapter extends RecyclerView.Adapter<CustomHomeAdapter.ViewHolder>{
    private ArrayList<dataHome> data;
    Context baseContext;
    private View view;

    public CustomHomeAdapter(ArrayList<dataHome> data, Context baseContext) {
        this.data = data;
        this.baseContext = baseContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_object.setText(data.get(position).getJudul());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(baseContext, MapsActivity.class);
                intent.putExtra("getKey", data.get(position).getKey());
                intent.putExtra("getValue", data.get(position).getJudul());
                baseContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_object;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_object = itemView.findViewById(R.id.tv_object);
        }
    }
}
