package com.shrimali.eduapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);


        Button GoProfile = findViewById(R.id.GoProfile);
        Button findresource = findViewById(R.id.findresource);

        //go to profile
        GoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboardActivity.this, StudentNavActivity.class);
                startActivity(intent);
            }
        });

        //To find resource
        findresource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDashboardActivity.this, ResourcesActivity.class);
                startActivity(intent);
            }
        });


    }
}