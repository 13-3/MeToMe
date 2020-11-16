package com.example.metome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriesActivity extends AppCompatActivity {


    ImageView ivClickProfile;
    TextView tvcategoryName;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        db = new DatabaseHelper(this);

        ivClickProfile = findViewById(R.id.ivClickProfile2);
        tvcategoryName = findViewById(R.id.tvcategoryName);

        Bundle extras = getIntent().getExtras();
        String username = null;

        if(extras!=null){
            username=extras.getString("username");
            //image= String.valueOf(db.getProfilePhoto(username));
            //image = extras.getString("profile");
           // String image = db.getProfilePhoto(username);
            String image = String.valueOf(db.getProfilePhoto(username));
            tvcategoryName.setText(username);
            ivClickProfile.setImageURI(Uri.parse(image));




        }


    }



}