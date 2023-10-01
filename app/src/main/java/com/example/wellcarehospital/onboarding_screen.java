package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class onboarding_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);
    }
    public void call_next(View v)
    {
        Intent i = new Intent(getApplicationContext(), onboarding_screen2.class);
        startActivity(i);
    }
}