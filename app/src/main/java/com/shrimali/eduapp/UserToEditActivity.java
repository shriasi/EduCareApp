package com.shrimali.eduapp;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class UserToEditActivity extends AppCompatActivity {

    private String accountType ;
    private String name;
    private String avatarURL ;
    private String email ;
    private String userId ;

    private TextView accountTypetxt ;
    private TextView nametxt;
    private ImageView avatarImg ;
    private TextView emailtxt ;
    private TextView schooltxt ;
    private TextView gradetxt ;
    private TextView phonetxt ;
    private TextView addresstxt ;
    private TextView subjectstxt ;


    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_to_edit);

        // get package name
        String packageName = getPackageName();

        // get data from shared preferences
        prefs = this.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        editor = prefs.edit();

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
        // load variables and fill the form
        nametxt.setText(name);
        emailtxt.setText(email);
        Picasso.get().load(avatarURL).into(avatarImg);


        //navigate to edit profile
        Button btn = (Button) findViewById(R.id.editPro);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
        {
            Intent intent = new Intent(UserToEditActivity.this, EditProfileActivity.class);
            startActivity(intent);
            finish();
        }
        });

    }

}