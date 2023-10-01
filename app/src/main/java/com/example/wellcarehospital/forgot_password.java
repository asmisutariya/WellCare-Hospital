package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class forgot_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
    public void call_con(View v)
    {
        Toast.makeText(getApplicationContext(), "Confirm Password", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), login_page.class);
        startActivity(i);
    }
}