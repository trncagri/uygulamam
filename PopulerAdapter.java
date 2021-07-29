package com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cagritaran.bitkitakibi.R;

import java.util.ArrayList;

public class PopulerAdapter extends RecyclerView.Adapter<PopulerAdapter.PopulerViewHolder> {

    ArrayList<PopulerHelperClass> populerLocations;

    public PopulerAdapter(ArrayList<PopulerHelperClass> mostViewedLocations) {
        this.populerLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public PopulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_bitkiler_card_design, parent, false);
        PopulerViewHolder PopulerViewHolder = new PopulerViewHolder(view);
        return PopulerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopulerViewHolder holder, int position) {
        PopulerHelperClass PopulerHelperClass = populerLocations.get(position);

        holder.image.setImageResource(PopulerHelperClass.getImage());
        holder.title.setText(PopulerHelperClass.getTitle());
        holder.desc.setText(PopulerHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return populerLocations.size();
    }

    public static class PopulerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public PopulerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.pb_image);
            title = itemView.findViewById(R.id.pb_title);
            desc = itemView.findViewById(R.id.pb_desc);
        }
    }
}