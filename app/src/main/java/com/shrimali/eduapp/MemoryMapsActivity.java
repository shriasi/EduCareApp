package com.shrimali.eduapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.shrimali.eduapp.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MemoryMapsActivity extends AppCompatActivity {
//
//    EditText editMemoname , editMention;
//    Button btnChoose, btnAdd, btnList;
//    ImageView imageView;
//
//    final int REQUEST_CODE_GALLERY = 999;
//
//    public static  SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_maps);

//        init();
//        sqLiteHelper = new SQLiteHelper(this,"DBNAME.sqlite", null, 1);
//        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS MEMORYMAPS (MemoID INTEGER PRIMARY KEY AUTOINCREMENT, memoname VARCHAR , mentions VARCHAR , imageView BLOG) ");
//
//        btnChoose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityCompat.requestPermissions(
//
//                        MemoryMapsActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        REQUEST_CODE_GALLERY
//                );
//            }
//        });
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    sqLiteHelper.insertMemoryMap(
//
//                        editMemoname.getText().toString().trim(),
//                        editMention.getText().toString().trim(),
//                        imageViewToByte(imageView)
//
//                );
//                Toast.makeText(getApplicationContext(),"Added successfully", Toast.LENGTH_SHORT).show();
//                editMemoname.setText("");
//                editMention.setText("");
//                imageView.setImageResource(R.mipmap.ic_launcher);
//
//
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }
//
//    private byte[] imageViewToByte(ImageView image) {
//
//        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] byteArray = stream.toByteArray();
//        return byteArray;
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if(requestCode == REQUEST_CODE_GALLERY){
//            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, REQUEST_CODE_GALLERY);
//            }
//            else{
//                Toast.makeText(getApplicationContext(), "you dont have permision", Toast.LENGTH_SHORT).show();
//            }
//            return;
//        }
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        if(requestCode ==  REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
//            Uri uri = data.getData();
//            try {
//                InputStream inputStream = getContentResolver().openInputStream(uri);
//
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                imageView.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    private void init(){
//
////        editMemoname = findViewById(R.id.editMemoname);
////        editMention = findViewById(R.id.editMention);
////        btnChoose = findViewById(R.id.btnChoose);
////        btnAdd = findViewById(R.id.btnAdd);
////        btnList = findViewById(R.id.btnList);
////        imageView = findViewById(R.id.imageView);



    }
}