package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class homepage extends AppCompatActivity {
Button signup,login;
ImageButton contwithfbbtn,continuewithgooglebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signup=(Button) findViewById(R.id.signupbtn);
        login=(Button) findViewById(R.id.loginbtn);
        continuewithgooglebtn= (ImageButton) findViewById(R.id.continue_with_googlebtn);
        contwithfbbtn= (ImageButton) findViewById(R.id.continue_with_facebookbtn);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////Sign up
                Log.d("Signup","Signup button clicked");
                Intent intent=new Intent(homepage.this, login_user.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login
                Log.d("Login","Login button clicked");
                Intent i=new Intent(homepage.this, Signup_User.class);
                startActivity(i);
            }
        });

        continuewithgooglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Contiue with google
                Log.d("Googlebtn","Continue with google clicked");

            }
        });
contwithfbbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Continue with facebook
        Log.d("Facebook btn","Contiue with face book clicked");
    }
});

    }
}