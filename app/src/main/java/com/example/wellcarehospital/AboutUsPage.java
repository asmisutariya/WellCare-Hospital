package com.example.wellcarehospital;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_page);
    }
    public void call_website(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apollohospital.com"));
        startActivity(i);
    }
    public void call_call(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8780476710"));
        startActivity(i);
    }
    public void call_map(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("22.47270213299797, 70.75427816645829"));
        startActivity(i);
    }
}