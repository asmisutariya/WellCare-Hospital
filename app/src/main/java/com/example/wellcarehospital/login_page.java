package com.example.wellcarehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;

    private FirebaseAuth mAuth;
    FirebaseUser user;
    private DatabaseReference mDatabaseRefrence;
    private static final String TAG = "EmailPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();

        email=  (EditText) findViewById(R.id.email);
        password = (EditText)  findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
//                if(email.getText().toString().equals("user") && password.getText().toString().equals("1234")){
//                    Toast.makeText(login_page.this,"Login Successfully",Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(getApplicationContext(),patient_main_page.class);
//                    startActivity(i);
//                }else{
//                    if(email.getText().toString().equals("asmi") && password.getText().toString().equals("123")){
//                    Toast.makeText(login_page.this,"Login Failed",Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(getApplicationContext(),doctor_main_page.class);
//                    startActivity(i);
//                }}
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }


    private void signIn() {
        // [START sign_in_with_email]
//        String email_Txt= String.valueOf(email);
//        String password_Txt= String.valueOf(email);
        String email_Txt = email.getText().toString().trim();
        String password_Txt = password.getText().toString().trim();
        if(!TextUtils.isEmpty(email_Txt) && !TextUtils.isEmpty(password_Txt)){

            mAuth.signInWithEmailAndPassword(email_Txt, password_Txt)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(login_page.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),patient_main_page.class);
                                startActivity(i);
                                updateUI(user);
//                              CheackUserExsists();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(login_page.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        }

        // [END sign_in_with_email]
    }

    private void CheackUserExsists() {

        final String user_id = mAuth.getCurrentUser().getUid();
        mDatabaseRefrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(login_page.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),patient_main_page.class);
                    startActivity(i);
                    updateUI(user);
//                    Intent MainIntent = new Intent(login_page.this,MainActivity.class);
//                    MainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(MainIntent);
                }else
                {

                    Toast.makeText(login_page.this,"You need to setup your Account.. ",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void reload() { }

    private void updateUI(FirebaseUser user) {
        Log.d("1223", user.toString());

    }
    public void call_forgotpass(View v)
    {
        Intent i= new Intent(getApplicationContext(),change_password.class);
        startActivity(i);
    }
}