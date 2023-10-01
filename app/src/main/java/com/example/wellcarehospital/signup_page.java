package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class signup_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
    }
    public void call_register(View v)
    {
        Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), login_page.class);
        startActivity(i);
    }
    public void call_btn1(View v)
    {
        Intent i = new Intent(getApplicationContext(), change_password.class);
        startActivity(i);
    }
}