package com.shrimali.eduapp;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "WelcomeActivity";
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    private static final int RC_SIGN_IN = 1;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton signInButton;
    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;
    private ToggleButton accountswitch;
    private TextView accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String packagen = getPackageName();

        prefs = this.getSharedPreferences(packagen, Context.MODE_PRIVATE);
        editor = prefs.edit();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.webId))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton= findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(0)
                        .playOn(findViewById(R.id.sign_in_button));
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        accountswitch= findViewById(R.id.accountswitch);
        accountType= findViewById(R.id.accountType);
        accountswitch.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RollIn)
                        .duration(1000)
                        .repeat(0)
                        .playOn(findViewById(R.id.accountType));
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(0)
                        .playOn(findViewById(R.id.accountswitch));
                if ( accountswitch.getText().toString().equalsIgnoreCase("Student Login")) {
                    accountType.setText("for Students");
                } else if ( accountswitch.getText().toString().equalsIgnoreCase("Teacher Login")) {
                    accountType.setText("for Teachers");
                }
            }
        });

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//         FirebaseUser currentUser = mAuth.getCurrentUser();
        signInButton= findViewById(R.id.sign_in_button);

        if (currentUser != null) {
//            String imageUri = Objects.requireNonNull(currentUser.getPhotoUrl()).toString();
//            ImageView ivBasicImage = findViewById(R.id.imageView);
//            Picasso.get().load(imageUri).into(ivBasicImage);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());

            } catch (ApiException e) {
                Toast.makeText(WelcomeActivity.this, "Sign In Failed!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("gauth", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            if(!prefs.contains("username")){
                                editor.putString("name", Objects.requireNonNull(user).getDisplayName());
                                editor.putString("id",user.getUid());
                                editor.putString("email",user.getEmail());
                                editor.putString("avatarURL", Objects.requireNonNull(user.getPhotoUrl()).toString());
                                editor.apply();
                            }

                            // Signed in successfully, show authenticated UI.
                            if (user != null) {
                                //start new activity for teacher
                                if(accountswitch.getText().toString().equalsIgnoreCase("Teacher Login")){
                                    editor.putString("accountType","teacher");
                                    editor.apply();

                                    Toast.makeText(WelcomeActivity.this, "Welcome Teacher!",
                                            Toast.LENGTH_LONG).show();
                                    // save data in shared preferences and navigate without data
                                    Intent myIntent = new Intent(WelcomeActivity.this, EditProfileActivity.class);
                                    WelcomeActivity.this.startActivity(myIntent);

                                }else{ // for students
                                    editor.putString("accountType","student");
                                    editor.apply();
                                    Toast.makeText(WelcomeActivity.this, "Welcome Student!",
                                            Toast.LENGTH_LONG).show();
                                    Intent myIntent = new Intent(WelcomeActivity.this, EditProfileActivity.class);
                                    WelcomeActivity.this.startActivity(myIntent);

                                }
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("gauth", "signInWithCredential:failure", task.getException());
                        }

                        // ...
                    }
                });
    }




    private void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

}