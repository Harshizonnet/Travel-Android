package com.example.travels_app.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travels_app.DetailsActivity;
import com.example.travels_app.R;
import com.example.travels_app.model.RecentsData;
import java.util.List;

public class RecentsAdapte extends RecyclerView.Adapter<RecentsAdapte.RecentviewHolder> {
    Context context;
    List<RecentsData>recentsDataList;

    public RecentsAdapte(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecentviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);
        return new RecentviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentviewHolder holder, int position) {
        holder.coutryname.setText(recentsDataList.get(position).getCountryname());
        holder.placename.setText(recentsDataList.get(position).getPlacename());
        holder.price.setText(recentsDataList.get(position).getPrice());
        holder.placeimage.setImageResource(recentsDataList.get(position).getImgeurl());


    }

    @Override
    public int getItemCount() {
        return
                recentsDataList.size();
    }

    public static final class RecentviewHolder extends RecyclerView.ViewHolder{
        ImageView placeimage;
        TextView placename,coutryname,price;
        public RecentviewHolder(@NonNull View itemView) {
            super(itemView);
            placeimage = itemView.findViewById(R.id.hotel_image);
            placename = itemView.findViewById(R.id.hotelname);
            coutryname = itemView.findViewById(R.id.placename);
            price = itemView.findViewById(R.id.price);
        }
    }



}





