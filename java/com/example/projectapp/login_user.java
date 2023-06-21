package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_user extends AppCompatActivity {


    EditText email1,username,password1;
    Button login;
    ProgressBar pbar;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i=new Intent(getApplicationContext(),Userscreen.class);
            startActivity(i);
            finish();
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        pbar=(ProgressBar)findViewById(R.id.progressBar2);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth=FirebaseAuth.getInstance();

        email1 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        username=(EditText) findViewById(R.id.Username);
        password1=(EditText) findViewById(R.id.Password);
        login=(Button) findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbar.setVisibility(View.VISIBLE);
                String name=username.getText().toString();
                String email=email1.getText().toString();
                String password=password1.getText().toString();
                if (TextUtils.isEmpty(email)){

                    Toast.makeText(login_user.this, "Enter Email!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){

                    Toast.makeText(login_user.this, "Enter Password!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pbar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(login_user.this, "Login Successfull",
                                            Toast.LENGTH_LONG).show();
                                    Intent i=new Intent(getApplicationContext(),Userscreen.class);
                                    i.putExtra("user",name);
                                    startActivity(i);
                                    finish();

                                } else {

                                    Toast.makeText(login_user.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });


    }
}