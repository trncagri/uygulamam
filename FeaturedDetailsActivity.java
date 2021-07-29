package com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cagritaran.bitkitakibi.R;
import com.cagritaran.bitkitakibi.databinding.ActivityFeaturedDetailsBinding;

public class FeaturedDetailsActivity extends AppCompatActivity {

    private ActivityFeaturedDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeaturedDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}