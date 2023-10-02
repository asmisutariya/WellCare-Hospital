package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class admin_main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);
    }
    public void call_feedback(View v)
    {
        Intent i = new Intent(getApplicationContext(),FeedbackPage.class);
        startActivity(i);
    }
    public void call_aboutus(View v)
    {
        Intent i = new Intent(getApplicationContext(),AboutUsPage.class);
        startActivity(i);
    }
}