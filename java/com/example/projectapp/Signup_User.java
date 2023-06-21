package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_User extends AppCompatActivity {
EditText email12,password12;
Button login;
ImageButton continuewithgoogle;
TextView loginpage;
ProgressBar pbar;
FirebaseAuth mAuth;

FirebaseDatabase database;
DatabaseReference reference;


EditText signupusername;
//    GoogleSignInOptions gso;
//    //GoogleSignInClient
//    GoogleSignInClient gsc;
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
        setContentView(R.layout.signuppage);
database=FirebaseDatabase.getInstance();
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth=FirebaseAuth.getInstance();
        loginpage=(TextView)findViewById(R.id.gotologin);
        continuewithgoogle=(ImageButton)findViewById(R.id.continue_with_googlebtn);

        signupusername=(EditText)findViewById(R.id.usernameinsignup) ;

//        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//
//
//        gsc= GoogleSignIn.getClient(this,gso);
//        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);


//continuewithgoogle.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Signin();
//    }
//});






        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Signup_User.this, login_user.class);
                startActivity(i);
                finish();
            }
        });


pbar=(ProgressBar)findViewById(R.id.progressBar);
        email12=(EditText) findViewById(R.id.email);
        password12=(EditText) findViewById(R.id.password1);
        login=findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                pbar.setVisibility(View.VISIBLE);
                email=String.valueOf(email12.getText());
                password=String.valueOf(password12.getText());
                if (TextUtils.isEmpty(email)){

                    Toast.makeText(Signup_User.this, "Enter Email!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){

                    Toast.makeText(Signup_User.this, "Enter Password!",
                            Toast.LENGTH_LONG).show();
                    return;
                }




                mAuth.createUserWithEmailAndPassword(email, password)

                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pbar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(Signup_User.this, "Account Created",
                                            Toast.LENGTH_SHORT).show();

//                                    String emaill=String.valueOf(email12.getText());
//                                    String password=String.valueOf(password12.getText());
//                                    String username=String.valueOf(signupusername.getText());
//
//
//                                    String id=task.getResult().getUser().getUid();
//                                    DatabaseReference reference=database.getReference().child("user").child("id");
//                                    Users user=new Users(emaill,username,password,id);
//                                    reference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            if(task.isSuccessful()){
//                                                Intent i=new Intent(Signup_User.this,login_user.class);
//                                                startActivity(i);
//                                                finish();
//                                            }
//                                            else{
//                                                Toast.makeText(Signup_User.this, "Error in creating user", Toast.LENGTH_SHORT).show();
//                                            }
//                                        }
//                                    });
//                                   String username=String.valueOf(signupusername.getText());
//                                    String emaill=String.valueOf(email12.getText());
//                                   String password=String.valueOf(password12.getText());
//                                Users user=new Users(emaill,username,password);
//
//                                    database=FirebaseDatabase.getInstance();
//                                    reference=database.getReference("users");
//                                    reference.child(username).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            Toast.makeText(Signup_User.this, "Success", Toast.LENGTH_SHORT).show();
//                                        }
//                                    });











                                } else {

                                    pbar.setVisibility(View.GONE);
                                    Toast.makeText(Signup_User.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });



    }

//    private void Signin() {
//
//        Intent i=gsc.getSignInIntent();
//        startActivityForResult(i,100);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==100){
//            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
//            HomeActivity();
//            try {
//                task.getResult(ApiException.class);
//            } catch (ApiException e) {
//                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
//            }
//        }
//    }

//    private void HomeActivity() {
//        finish();
//        Intent i=new Intent(getApplicationContext(),Userscreen.class);
//        startActivity(i);
//    }
}