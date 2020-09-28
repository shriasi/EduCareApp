package com.asiri.eduappnavigation;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class StudentNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_nav);

        final DrawerLayout drawerLayout =  findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController( this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

         //Meka dammama saved profile eka wada karannh
//        Button yourButton = (Button) findViewById(R.id.goback);
//
//        yourButton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                startActivity(new Intent(StudentNavActivity.this, MainDashboardActivity.class));
//                Toast.makeText(StudentNavActivity.this, "Waiting for profile", Toast.LENGTH_LONG).show();
//            }
//        });

    }
}