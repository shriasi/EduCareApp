package com.asiri.eduappnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        Button yourButton = (Button) findViewById(R.id.goback);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainDashboardActivity.this, StudentNavActivity.class));
                Toast.makeText(MainDashboardActivity.this, "Waiting for profile", Toast.LENGTH_LONG).show();
            }
        });
    }
}