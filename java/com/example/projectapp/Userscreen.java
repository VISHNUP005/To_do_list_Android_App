package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Userscreen extends AppCompatActivity {
    TextView username;
    FirebaseAuth auth;
    ImageButton logout;
    TextView emailshow;
    Button addtask,viewtask;
    FirebaseUser user;
    RecyclerView mainuserrecyclerview;

    UserAdapter adapter;
    FirebaseDatabase database;
    ArrayList<Users> usersArrayList;
//   s
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userscreen);
username=(TextView)findViewById(R.id.usernamshow);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        auth=FirebaseAuth.getInstance();
        logout=(ImageButton) findViewById(R.id.logout);
        emailshow=(TextView) findViewById(R.id.usernameemail);

        user=auth.getCurrentUser();

        Intent in=getIntent();
        String message=in.getStringExtra("user");
        String message1=user.getEmail();
//        Bundle bundle=getIntent().getExtras();
//        String message=bundle.getString("username");
//        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//
//
//        gsc= GoogleSignIn.getClient(this,gso);
//        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
//        if(account!=null){
//            String Name=account.getDisplayName();
//            String Mail=account.getEmail();
//            emailshow.setText(Name);
//
//        }
//
//
//
//
//        mainuserrecyclerview=findViewById(R.id.mainuserrecyclerview);
//        mainuserrecyclerview.setLayoutManager(new LinearLayoutManager(this));
//
//        mainuserrecyclerview.setAdapter(adapter);
//        database=FirebaseDatabase.getInstance();
//        DatabaseReference reference=database.getReference().child("user");
//        usersArrayList=new ArrayList<>();
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//                    Users user=dataSnapshot.getValue(Users.class);
//                    usersArrayList.add(user);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//
//
//adapter=new UserAdapter(Userscreen.this,usersArrayList);








addtask=(Button) findViewById(R.id.addtask);
viewtask=(Button)findViewById(R.id.viewtask);
addtask.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),addtask.class);
        i.putExtra("username",message);
        startActivity(i);

    }
});
viewtask.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(Userscreen.this,viewtaskactivity.class);
        startActivity(i);
        finish();
    }
});
        if (user==null){
            Intent i=new Intent(getApplicationContext(), login_user.class);
            startActivity(i);
            finish();
        }
        else{

            emailshow.setText(user.getEmail());
            username.setText(message);

        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(), login_user.class);
                startActivity(i);
                finish();
            }
        });
    }
}