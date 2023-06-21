package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addtask extends AppCompatActivity {
Button addtask,backbtn;
EditText task,username123,taskno;
    int i=0;
    FirebaseDatabase database;
    ProgressBar pbar1;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);
database=FirebaseDatabase.getInstance();



        username123=(EditText)findViewById(R.id.name);
        taskno=(EditText)findViewById(R.id.taskno);
        addtask=(Button)findViewById(R.id.addtask1);
        backbtn=(Button)findViewById(R.id.back);
        task=(EditText)findViewById(R.id.newtask);
        String message=username123.getText().toString();
//        String message=username123.getText().toString();
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(addtask.this,Userscreen.class);
                startActivity(i);
                finish();
            }
        });

        addtask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String addtask1=String.valueOf(task.getText());
               String username=String.valueOf(username123.getText());
               i++;
               String taskno1=String.valueOf(taskno.getText());
                addtaskclass ad=new addtaskclass(addtask1);

                database= FirebaseDatabase.getInstance();
                reference=database.getReference(username);
                reference.child(taskno1).setValue(ad).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(addtask.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });











    }
}