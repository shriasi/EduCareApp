package com.shrimali.eduapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shrimali.logic.User;


public class EditProfileActivity extends AppCompatActivity {
    EditText school;
    EditText email;
    EditText name;
    EditText grade;
    EditText phone;
    EditText address;
    EditText subjects;
    Button save;
    DatabaseReference UserDBRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile2);

        school = findViewById(R.id.school);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        grade = findViewById(R.id.grade);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        subjects = findViewById(R.id.subjects);

        UserDBRef = FirebaseDatabase.getInstance().getReference().child("User");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUserDetails();
            }
        });
    }

    private void insertUserDetails() {

    String UserSchool = school.getText().toString();
    String UserGrade = grade.getText().toString();
    String UserPhone = phone.getText().toString();
    String UserAddress = address.getText().toString();
    String UserSubjects = grade.getText().toString();

    User user = new User(UserSchool,UserGrade,UserPhone,UserAddress,UserSubjects);

        UserDBRef.push().setValue(user);
        Toast.makeText(EditProfileActivity.this, "Success!" , Toast.LENGTH_SHORT).show();
    }
}