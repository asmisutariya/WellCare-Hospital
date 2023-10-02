package com.example.wellcarehospital;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signup_page extends AppCompatActivity{

    EditText mno;
    EditText age;
//    Button signup;
    EditText Email, Password, Name,Gender;
//    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference ref;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        signup=(Button)findViewById(R.id.signup);

        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        mno=(EditText)findViewById(R.id.mobileno);
        Password=(EditText)findViewById(R.id.password);
        age=(EditText)findViewById(R.id.age);
        Gender=(EditText)findViewById(R.id.gender);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });
    }

    private void RegisterUser() {
        final String email = Email.getText().toString().trim();
        final String password = Password.getText().toString().trim();
        final String name = Name.getText().toString().trim();

        final String gender = Gender.getText().toString();

        if(email.isEmpty()){
            Email.setError("Email is required.");
            Email.requestFocus();
            return ;
        }

        if(name.isEmpty()){
            Name.setError("Username is required.");
            Name.requestFocus();
            return ;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please enter a valid email");
            Email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            Password.setError("Password is required.");
            Password.requestFocus();
            return ;
        }

        if(password.length() < 6){
            Password.setError("Password minimum length should be 6 characters.");
            Password.requestFocus();
            return ;
        }

//        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

//                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(), "Patient account created successfully.", Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();

//                    if()

                    ref = FirebaseDatabase.getInstance().getReference("Patient:").child(userId);


                    User user = new User(userId,name,email,password,"Default", gender,"Default","Default","Default");

                    ref.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {
                                Intent intent = new Intent(signup_page.this, patient_main_page.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                finish();
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });





                }else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException) {

                        Toast.makeText(getApplicationContext(), "Patient Account Already Registered.", Toast.LENGTH_LONG).show();

                    }else{

                        Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
            }

        });
    }

}
