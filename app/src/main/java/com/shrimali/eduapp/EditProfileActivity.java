package com.shrimali.eduapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.shrimali.logic.DatabaseHelper;

public class EditProfileActivity extends AppCompatActivity {
    EditText name,school,grade,email,phone,address;
    Button save;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.name);
        school = findViewById(R.id.school);
        grade = findViewById(R.id.grade);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        save = findViewById(R.id.savedata);

        databaseHelper = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= name.getText().toString();
                String userschool = school.getText().toString();
                String usergrade = school.getText().toString();
                String useremail = email.getText().toString();
                String useraddress = address.getText().toString();
                String userphone = phone.getText().toString();


                if(username.length()>1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", username);
                    contentValues.put("school", userschool);
                    contentValues.put("grade", usergrade);
                    contentValues.put("email", useremail);
                    contentValues.put("address", useraddress);
                    contentValues.put("phone",  userphone);

                    databaseHelper.insertUser(contentValues);
                    Intent intent = new Intent(EditProfileActivity.this , MainDashboardActivity.class);
                    startActivity(intent);
                    Toast.makeText(EditProfileActivity.this, "Profile data saved!" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfileActivity.this, "Enter correct info!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}