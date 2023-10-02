package com.example.wellcarehospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackPage extends AppCompatActivity {
    EditText fname;
    EditText email;
    EditText message;
    Button submit;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feedback_page);

        firebaseDatabase=FirebaseDatabase.getInstance();

        fname=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        message=(EditText)findViewById(R.id.msg);

        submit=(Button)findViewById(R.id.btnsubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataholderfeedback map=new dataholderfeedback();

                map.setFullName(fname.getText().toString());
                map.setEmailID(email.getText().toString());
                map.setMessage(message.getText().toString());
                firebaseDatabase.getReference().child("tblfeedback").push().setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(FeedbackPage.this, "Feedback Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(FeedbackPage.this, "Feedback Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}