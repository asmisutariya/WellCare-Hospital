package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class map_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);
    }
    public void call_web(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
        startActivity(i);
    }
    public void call_phone(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+9929920544"));
        startActivity(i);
    }
    public void call_map(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:21.154465150939373, 72.7831883"));
        startActivity(i);
    }
}
