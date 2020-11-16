package com.example.metome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button btnlSignup,btnLogin;
    EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        db = new DatabaseHelper(this);

        etUsername = findViewById(R.id.etUsernameLogin);
        etPassword = findViewById(R.id.etPassword);

        btnlSignup = findViewById(R.id.btnlSignup);

        btnLogin = findViewById(R.id.btnLogin);

        btnlSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signupIntent);

            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();



                boolean res = db.checkUser(username, password);

                if (res) {
                    Intent categoryIntent = new Intent(LoginActivity.this, CategoriesActivity.class);
                    categoryIntent.putExtra("username",username);


                    startActivity(categoryIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Not register, Please Sign up", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}