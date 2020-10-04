package com.shrimali.eduapp;

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

import android.os.Bundle;
import android.view.View;

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


////        //getting profile details
////        DatabaseHelper databaseHelper = new DatabaseHelper(this);
////
////        TextView name = findViewById(R.id.name);
////        TextView email = findViewById(R.id.email);
////        TextView school = findViewById(R.id.school);
////        TextView grade = findViewById(R.id.grade);
////        TextView phone= findViewById(R.id.phone);
//        Button gotodashboard = findViewById(R.id.gotodashboard);
//
////
////        Cursor cursor = databaseHelper.ViewData();
////
////        StringBuilder stringBuilder = new StringBuilder();
////
//////        while(cursor.moveToNext()){
//////
//////            StringBuilder.append(""cursor.getString(1) + "email")
//////        }
//////
    }
}