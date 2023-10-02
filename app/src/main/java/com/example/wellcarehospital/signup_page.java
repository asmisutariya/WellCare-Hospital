package com.example.wellcarehospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup_page extends AppCompatActivity {
    EditText fname;
    EditText email;
    EditText mno;
    EditText age;
    EditText password;
    Button signup;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        firebaseDatabase=FirebaseDatabase.getInstance();

        fname=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        mno=(EditText)findViewById(R.id.mobileno);
        age=(EditText)findViewById(R.id.age);
        password=(EditText)findViewById(R.id.password);

        signup=(Button)findViewById(R.id.signupbutton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataholderregister map=new dataholderregister();

                map.setFullName(fname.getText().toString());
                map.setEmailID(email.getText().toString());
                map.setMoblieNo(mno.getText().toString());
                map.setAge(age.getText().toString());
                map.setPassword(password.getText().toString());


//                HashMap<String,Object> map=new HashMap<>();
//                map.put("fullname", fname.getText().toString());
//                map.put("emailid", email.getText().toString());
//                map.put("mno", mno.getText().toString());
//                map.put("age", age.getText().toString());
//                map.put("password", password.getText().toString());

                firebaseDatabase.getReference().child("tblpatient").push().setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(signup_page.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), login_page.class);
                                startActivity(i);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(signup_page.this, "Register Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

//    public void call_register(View v)
//    {
//
//        String FullName=fname.getText().toString().trim();
//        String EmailID=email.getText().toString().trim();
//        String MoblieNo=mno.getText().toString().trim();
//        String Age=age.getText().toString().trim();
//        String Password=password.getText().toString().trim();
//
//        dataholderregister obj=new dataholderregister(FullName,EmailID,MoblieNo,Age,Password);
//
//        FirebaseDatabase db=FirebaseDatabase.getInstance();
//        DatabaseReference node=db.getReference("tblpatient");
//
//
//
//        Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(getApplicationContext(), login_page.class);
//        startActivity(i);
//    }
}