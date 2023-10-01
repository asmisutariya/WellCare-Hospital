package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class loading_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);
    }
    public void call_adminlogin(View v)
    {
        Intent i = new Intent(getApplicationContext(), admin_main_page.class);
        startActivity(i);
    }
    public void call_doctorlogin(View v)
    {
        Intent i = new Intent(getApplicationContext(), doctor_main_page.class);
        startActivity(i);
    }
    public void call_login(View v)
    {
        Intent i = new Intent(getApplicationContext(), login_page.class);
        startActivity(i);
    }
    public void call_signup(View v)
    {
        Intent i = new Intent(getApplicationContext(), signup_page.class);
        startActivity(i);
    }
}