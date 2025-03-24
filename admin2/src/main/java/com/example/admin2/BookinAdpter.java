package com.example.admin2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookinAdpter extends RecyclerView.Adapter<BookinAdpter.MyViewHolder> {
    Context context;
    ArrayList<bookindataclass> list;

    public BookinAdpter(Context context, ArrayList<bookindataclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BookinAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rdrivebooking,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       bookindataclass eventData=list.get(position);
        holder.Hname.setText(eventData.getName());
        holder.Hemail.setText(eventData.getEmail());
        holder.Hphone.setText(eventData.getNumber());
        holder.Hadhar.setText(eventData.getAdharcardNumber());
        holder.Hhotlname.setText(eventData.getHotelname());
        holder.Hindate.setText(eventData.getSet_CheckInDate());
        holder.Houtdate.setText(eventData.getSet_CheckOutDate());
        holder.Htime.setText(eventData.getSet_time());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Hname, Hemail, Hphone, Hadhar, Hhotlname, Hindate, Houtdate, Htime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Hname = itemView.findViewById(R.id.name);
            Hemail = itemView.findViewById(R.id.email);
            Hphone = itemView.findViewById(R.id.phone);
            Hadhar = itemView.findViewById(R.id.adhar);
            Hhotlname = itemView.findViewById(R.id.hotelname);
            Hindate = itemView.findViewById(R.id.indate);
            Houtdate = itemView.findViewById(R.id.outdate);
            Htime = itemView.findViewById(R.id.time); // Initialize Htime TextView
        }
    }
    }


