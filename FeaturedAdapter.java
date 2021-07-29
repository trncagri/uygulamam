package com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cagritaran.bitkitakibi.R;
import com.cagritaran.bitkitakibi.databinding.FeaturedCardDesignerBinding;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.featuredViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public featuredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FeaturedCardDesignerBinding featuredCardDesignerBinding = FeaturedCardDesignerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new featuredViewHolder(featuredCardDesignerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.featuredViewHolder holder, int position) {

        holder.binding.featuredTitle.setText(featuredLocations.get(position).title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),FeaturedDetailsActivity.class);
                intent.putExtra("Featured",featuredLocations.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class featuredViewHolder extends RecyclerView.ViewHolder{

        private FeaturedCardDesignerBinding binding;



        public featuredViewHolder(FeaturedCardDesignerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;



        }
    }

}
