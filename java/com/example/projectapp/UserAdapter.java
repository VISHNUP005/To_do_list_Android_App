package com.example.projectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder> {
    Userscreen userscreen;
    ArrayList<Users> usersArrayList;
    public UserAdapter(Userscreen userscreen, ArrayList<Users> usersArrayList) {
        this.userscreen=userscreen;
        this.usersArrayList=usersArrayList;
    }

    @NonNull
    @Override
    public UserAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(userscreen).inflate(R.layout.user_item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewholder holder, int position) {


    }

    @Override
    public int getItemCount() {

        return usersArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView username;
        TextView mail;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.usernameinuseritem);
            mail=itemView.findViewById(R.id.mailid);


        }
    }
}
