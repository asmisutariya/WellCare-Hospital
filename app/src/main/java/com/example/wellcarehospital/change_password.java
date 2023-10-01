package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }
    public void call_fpass(View v)
    {
        Intent i = new Intent(getApplicationContext(), forgot_password.class);
        startActivity(i);
    }
    public void call_set(View v)
    {
        Toast.makeText(getApplicationContext(), "Set Password", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), login_page.class);
        startActivity(i);
    }
}