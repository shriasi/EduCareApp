package com.asiri.eduappnavigation;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button yourButton = (Button) findViewById(R.id.savebtn);
        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EditProfileActivity.this, StudentNavActivity.class));
                Toast.makeText(EditProfileActivity.this, "Waiting for profile", Toast.LENGTH_LONG).show();
            }
        });
    }
}