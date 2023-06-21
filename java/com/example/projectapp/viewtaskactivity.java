package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class viewtaskactivity extends AppCompatActivity {
DatabaseReference reference;
TextView showtask;
Button find,back;
EditText taskno,name;
ProgressBar ppbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtaskactivity);
name=(EditText)findViewById(R.id.nameinviewtask); 
        taskno=(EditText) findViewById(R.id.tasknumber);
        find=(Button) findViewById(R.id.findbtn);
        back=(Button) findViewById(R.id.backbtn);
        ppbar=(ProgressBar)findViewById(R.id.pbar);
showtask=(TextView)findViewById(R.id.showtasktextview);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppbar.setVisibility(View.VISIBLE);
                String taskno1=String.valueOf(taskno.getText());
                readData(taskno1);
            }
        });


back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(viewtaskactivity.this,Userscreen.class);
        startActivity(i);
    }
});

    }

    private void readData(String taskno1) {
        reference= FirebaseDatabase.getInstance().getReference(String.valueOf(name.getText()));
        reference.child(taskno1).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    ppbar.setVisibility(View.GONE);
                    if(task.getResult().exists()){
                        Toast.makeText(viewtaskactivity.this, "Successfully read", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot=task.getResult();
                        String taskname=String.valueOf(dataSnapshot.child("task").getValue());
                        showtask.setText(taskname);
                    }
                    else{
                        Toast.makeText(viewtaskactivity.this, "User Doesnt Exist", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(viewtaskactivity.this, "Failed to read Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}