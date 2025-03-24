package com.example.travels_app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travels_app.R;
import com.example.travels_app.model.Dataclass;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Dataclass>list;
    OnClick onClick;

    public MyAdapter(Context context, ArrayList<Dataclass> list, OnClick onClick) {
        this.context = context;
        this.list = list;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_redrive,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Dataclass dataclass=list.get(position);
        if (list !=null) {
            holder.ttitletext.setText(dataclass.getFileName());
            //holder.tlistpic.setText(dataclass.getImageUrl());
            Glide.with(context).load(dataclass.getImageUrl()).into(holder.listpic);

        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.ItemOnClick(dataclass.getNodeId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ttitletext;
        ImageView listpic;
        CardView cardView;
        @SuppressLint("WrongViewCast")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ttitletext=itemView.findViewById(R.id.titalTxt);
            listpic =itemView.findViewById(R.id.listpic);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
