package com.cagritaran.bitkitakibi.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.PopulerAdapter;
import com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter.PopulerHelperClass;
import com.cagritaran.bitkitakibi.R;
import com.cagritaran.bitkitakibi.databinding.ActivityUserDashboardBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private @NonNull ActivityUserDashboardBinding binding;

    //Veriables
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, categoriesRecycler, populerRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityUserDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        categoriesRecycler = findViewById(R.id.categories_reycyler);
        populerRecycler = findViewById(R.id.populer_recycler);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

       navigationDrawer();


        //Recycler View Function Calls
        featuredRecycler();
        categoriesRecycler();
        populerRecycler();


    }

    // Navigation Drawer Function Calls
    private void navigationDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategories.class));
                break;

        }

        switch (item.getItemId()){

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),UserDashboard.class));
                break;

        }

        return true;
    }




    //Recycler View Function
    private void categoriesRecycler() {

        //All Gradients
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});



        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.yaprakli_bitkiler, "Yapraklı Bitkiler"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.yaprakli_bitkiler, "Yapraklı Bitkiler"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.yaprakli_bitkiler, "Yapraklı Bitkiler"));



        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void populerRecycler() {

        populerRecycler.setHasFixedSize(true);
        populerRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PopulerHelperClass> populerLocations = new ArrayList<>();
        populerLocations.add(new PopulerHelperClass(R.drawable.populer_kroton, "Kroton","Genelde gösterişli yaprakları için yetiştirilen kroton bitkisi oldukça dekoratif ve iri yapraklara sahiptir."));
        populerLocations.add(new PopulerHelperClass(R.drawable.populer_kroton, "Kroton","Genelde gösterişli yaprakları için yetiştirilen kroton bitkisi oldukça dekoratif ve iri yapraklara sahiptir."));
        populerLocations.add(new PopulerHelperClass(R.drawable.populer_kroton, "Kroton","Genelde gösterişli yaprakları için yetiştirilen kroton bitkisi oldukça dekoratif ve iri yapraklara sahiptir."));


        adapter = new PopulerAdapter(populerLocations);
        populerRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();



        //Data
        FeaturedHelperClass pasaKilici = new FeaturedHelperClass(R.drawable.pasa_kilici,"Paşa Kılıcı", "Dilimizde Paşa KıIıcı, Peygamber Kılıcı olarak bilinen Sansevieria’ların bakımları oldukça kolaydır.");

        featuredLocations.add(pasaKilici);

        featuredLocations.add(new FeaturedHelperClass(R.drawable.pasa_kilici, "Paşa Kılıcı", "Dilimizde Paşa KıIıcı, Peygamber Kılıcı olarak bilinen Sansevieria’ların bakımları oldukça kolaydır."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yaprakli_bitkiler, "Yaprak Kılıcı", "Dilimizde Paşa KıIıcı, Peygamber Kılıcı olarak bilinen Sansevieria’ların bakımları oldukça kolaydır."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pasa_kilici, "Paşa Kılıcı", "Dilimizde Paşa KıIıcı, Peygamber Kılıcı olarak bilinen Sansevieria’ların bakımları oldukça kolaydır."));

        adapter = new FeaturedAdapter(featuredLocations);
        binding.featuredRecycler.setAdapter(adapter);



    }


}