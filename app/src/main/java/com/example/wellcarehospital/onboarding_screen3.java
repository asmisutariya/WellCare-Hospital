package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class onboarding_screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen3);
    }
    public void call_skip(View v)
    {
        Intent i = new Intent(getApplicationContext(), loading_page.class);
        startActivity(i);
    }
    public void call_next(View v)
    {
        Intent i = new Intent(getApplicationContext(), loading_page.class);
        startActivity(i);
    }
}