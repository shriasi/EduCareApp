package com.shrimali.eduapp;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;


public class EditProfileActivity extends AppCompatActivity {

    private String accountType ;
    private String name;
    private String avatarURL ;
    private String email ;
    private String userId ;

    private TextView accountTypetxt ;
    private TextView nametxt;
    private ImageView avatarImg ;
    private TextView emailtxt ;

    private Button saveButtton;

    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // get package name
        String packageName = getPackageName();

        // get data from shared preferences
        prefs = this.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        editor = prefs.edit();

        // check if shared preferences are exist
        if(!prefs.contains("name")){
            Toast.makeText(EditProfileActivity.this, "shared prefs have not been saved.",
                    Toast.LENGTH_LONG).show();
            Log.w("Edit profile activity", "shared prefs have not been saved");
            Intent myIntent = new Intent(EditProfileActivity.this, WelcomeActivity.class);
            EditProfileActivity.this.startActivity(myIntent);
        } else if(prefs.getString("name", "").equals("")){
            Toast.makeText(EditProfileActivity.this, "Invalid login. user details not found",
                    Toast.LENGTH_LONG).show();
            Log.w("Edit profile activity", "Invalid login. user details not found");
            Intent myIntent = new Intent(EditProfileActivity.this, WelcomeActivity.class);
            EditProfileActivity.this.startActivity(myIntent);
        }

        name = prefs.getString("name", "default name");
        accountType = prefs.getString("accountType", "student");
        avatarURL = prefs.getString("avatarURL", "");
        email = prefs.getString("email", "defaultemail@gmail.com");
        userId = prefs.getString("id", "");

        // get elements
        nametxt = (TextView) findViewById(R.id.name);
        emailtxt = (TextView) findViewById(R.id.email);
        accountTypetxt = (TextView) findViewById(R.id.accountType);
        avatarImg = (ImageView) findViewById(R.id.avatar);
        saveButtton = (Button) findViewById(R.id.savebtn);

        // load variables and fill the form
        nametxt.setText(name);
        emailtxt.setText(email);
        Picasso.get().load(avatarURL).into(avatarImg);

        // on click events - on save button click
        saveButtton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EditProfileActivity.this, StudentNavActivity.class));
                Toast.makeText(EditProfileActivity.this, "Waiting for profile", Toast.LENGTH_LONG).show();
            }
        });





    }
}