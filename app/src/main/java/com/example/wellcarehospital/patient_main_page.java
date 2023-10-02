package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class patient_main_page extends AppCompatActivity {

    CardView bookAppoiment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main_page);

        bookAppoiment=findViewById(R.id.block1);
        bookAppoiment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),Book_Appoiment_Page.class);
                    startActivity(i);

            }
        });
    }
    public void call_patientprofile(View v)
    {
        Intent i = new Intent(getApplicationContext(),patient_profile_page.class);
        startActivity(i);
    }
    public void call_feedback(View v)
    {
        Intent i = new Intent(getApplicationContext(),FeedbackPage.class);
        startActivity(i);
    }
    public void call_em(View v)
    {
        Intent i = new Intent(getApplicationContext(), onboarding_screen3.class);
        startActivity(i);
    }
}