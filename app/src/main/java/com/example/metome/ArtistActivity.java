package com.example.metome;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metome.Adapters.AdapterArtistRecord;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ArtistActivity extends AppCompatActivity {

    private RecyclerView rvPieceArtist;

    ImageView ivPeice_image;
    TextView tvPiece_name;
    Button btnAdd_piece;


    DatabaseHelper db;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Pieces");


        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rvPieceArtist = findViewById(R.id.rvPieceArtist);

        ivPeice_image = findViewById(R.id.ivPeice_image);
        tvPiece_name = findViewById(R.id.tvPiece_name);
        btnAdd_piece = findViewById(R.id.btnAdd_piece);


        db = new DatabaseHelper(this);

        btnAdd_piece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ArtistActivity.this,AddPieceActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return super.onSupportNavigateUp();
    }


    private void loadRecords()
    {
        AdapterArtistRecord adapterArtistRecord = new AdapterArtistRecord(this,
                db.getAllPieces());

         rvPieceArtist.setAdapter(adapterArtistRecord);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadRecords();
    }



}