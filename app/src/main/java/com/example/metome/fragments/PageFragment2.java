package com.example.metome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.metome.LoginSignUpActivity;
import com.example.metome.R;

public class PageFragment2 extends Fragment {

    TextView tvSkip2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_2,container,false);



        tvSkip2 = rootView.findViewById(R.id.tvSkip2);
        tvSkip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginSignUpActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }
}