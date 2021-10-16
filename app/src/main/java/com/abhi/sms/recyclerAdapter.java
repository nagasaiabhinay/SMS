package com.abhi.sms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<Card> usersList;

    public recyclerAdapter(ArrayList<Card> usersList){
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView number;
        private TextView message;

        public MyViewHolder(final View view){
            super(view);
            number = view.findViewById(R.id.Number);
            message = view.findViewById(R.id.Message);
        }

    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_card,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String number = usersList.get(position).getNumber();
        holder.number.setText(number);
        String message = usersList.get(position).getMessage();
        holder.message.setText(message);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
