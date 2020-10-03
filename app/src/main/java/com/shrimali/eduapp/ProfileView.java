//package com.shrimali.eduapp;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ProfileView extends AppCompatActivity {
//
//    private TextView accountTypetxt ;
//    private TextView nametxt;
//    private ImageView avatarImg ;
//    private TextView emailtxt ;
//    private TextView schooltxt ;
//    private TextView gradetxt ;
//    private TextView phonetxt ;
//
//    private String accountType ;
//    private String name;
//    private String avatarURL ;
//    private String email ;
//    private String userId ;
//
//    private static SharedPreferences prefs;
//    private static SharedPreferences.Editor editor;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile_view);
//
//        // get package name
//        String packageName = getPackageName();
//
//        // get data from shared preferences
//        prefs = this.getSharedPreferences(packageName, Context.MODE_PRIVATE);
//        editor = prefs.edit();
//
//        // get elements
////        nametxt = (TextView) findViewById(R.id.fullname);
//        emailtxt = (TextView) findViewById(R.id.email);
//        accountTypetxt = (TextView) findViewById(R.id.accountType);
//        schooltxt = (TextView) findViewById(R.id.school);
//        avatarImg = (ImageView) findViewById(R.id.avatar);
//        gradetxt = (TextView) findViewById(R.id.grade);
//        phonetxt = (TextView) findViewById(R.id.phone);
//
////        name = prefs.getString("name", "default name");
//        accountType = prefs.getString("accountType", "student");
//        avatarURL = prefs.getString("avatarURL", "");
//        email = prefs.getString("email", "defaultemail@gmail.com");
//        userId = prefs.getString("id", "");
//
//        // set data
//        nametxt.setText(name);
//        emailtxt.setText(email);
//
//    }
//}