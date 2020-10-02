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
import com.shrimali.logic.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.Objects;


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
    private TextView schooltxt ;
    private TextView gradetxt ;
    private TextView phonetxt ;
    private TextView addresstxt ;
    private TextView subjectstxt ;

    private Button saveButtton;

    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;

//    DatabaseHelper DB;

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
        nametxt = (TextView) findViewById(R.id.fullname);
        emailtxt = (TextView) findViewById(R.id.email);
        accountTypetxt = (TextView) findViewById(R.id.accountType);
        schooltxt = (TextView) findViewById(R.id.school);
        avatarImg = (ImageView) findViewById(R.id.avatar);
        gradetxt = (TextView) findViewById(R.id.grade);
        phonetxt = (TextView) findViewById(R.id.phone);
        addresstxt = (TextView) findViewById(R.id.address);
        subjectstxt = (TextView) findViewById(R.id.subjects);
        saveButtton = (Button) findViewById(R.id.savebtn);

        // load variables and fill the form
        nametxt.setText(name);
        emailtxt.setText(email);
        Picasso.get().load(avatarURL).into(avatarImg);

        // on click events - on save button click
        saveButtton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // save form data
                if(prefs.contains("id")){
                    if(validate()) {
                        editor.putString("name", nametxt.getText().toString());
                        editor.putString("school", schooltxt.getText().toString());
                        editor.putString("grade", gradetxt.getText().toString());
                        editor.putString("subjects", subjectstxt.getText().toString());
                        editor.putString("phone", phonetxt.getText().toString());
                        editor.putString("address", addresstxt.getText().toString());
                        editor.apply();
                        startActivity(new Intent(EditProfileActivity.this, ProfileView.class));
                    }

                }else{
                    Toast.makeText(EditProfileActivity.this, "Please log in with Google.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EditProfileActivity.this, WelcomeActivity.class));
                }
            }
        });
    }

    private boolean validate(){
        if(!nametxt.getText().toString().equals("")){
            if(!emailtxt.getText().toString().equals("") || isValidEmailAddress(emailtxt.getText().toString())){
                if(!schooltxt.getText().toString().equals("")){
                    if(!gradetxt.getText().toString().equals("")){
                        if(!phonetxt.getText().toString().equals("") || isValidPhone(phonetxt.getText().toString())){
                            if(!addresstxt.getText().toString().equals("")){
                                return true;
                            }else{
                                Toast.makeText(EditProfileActivity.this, "Invalid address number. Please re-check!", Toast.LENGTH_LONG).show();
                                return false;
                            }
                        }else{
                            Toast.makeText(EditProfileActivity.this, "Invalid Phone number. Please re-check!", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    }else{
                        Toast.makeText(EditProfileActivity.this, "Invalid Grade. Please re-check!", Toast.LENGTH_LONG).show();
                        return false;
                    }
                }else{
                    Toast.makeText(EditProfileActivity.this, "Invalid School Name. Please re-check!", Toast.LENGTH_LONG).show();
                    return false;
                }
            }else{
                Toast.makeText(EditProfileActivity.this, "Invalid Email. Please re-check!", Toast.LENGTH_LONG).show();
                return false;
            }
        }else{
            Toast.makeText(EditProfileActivity.this, "Invalid Name. Please re-check!", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidPhone(String phone) {
        String ePattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phone);
        return m.matches();
    }

}