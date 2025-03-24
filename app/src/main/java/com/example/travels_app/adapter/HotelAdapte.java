package com.example.travels_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travels_app.R;
import com.example.travels_app.model.HotelData;

import java.util.List;

public class HotelAdapte extends RecyclerView.Adapter<HotelAdapte.HotelviewHolder> {

    Context context;
    List<HotelData> hotelDataList;

    public HotelAdapte(Context context, List<HotelData> hotelDataList) {
        this.context = context;
        this.hotelDataList = hotelDataList;
    }

    @NonNull
    @Override
    public HotelviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotel_row_item,parent,false);
        return new HotelviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelviewHolder holder, int position) {
          holder.Hotelname.setText(hotelDataList.get(position).getHotelname());
          holder.placename.setText(hotelDataList.get(position).getPlacename());
          holder.price.setText(hotelDataList.get(position).getPrice());
          holder.HotelImage.setImageResource(hotelDataList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    public static  final class HotelviewHolder extends RecyclerView.ViewHolder{
        ImageView HotelImage;
        TextView Hotelname,placename,price;
        public HotelviewHolder(@NonNull View itemView) {
            super(itemView);

            HotelImage = itemView.findViewById(R.id.hotel_image);
            Hotelname = itemView.findViewById(R.id.hotelname);
            placename = itemView.findViewById(R.id.placename);
            price = itemView.findViewById(R.id.price);
        }
    }
}
