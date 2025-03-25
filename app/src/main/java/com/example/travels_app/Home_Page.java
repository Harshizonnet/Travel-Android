package com.example.travels_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travels_app.adapter.HotelAdapte;
import com.example.travels_app.adapter.RecentsAdapte;
import com.example.travels_app.model.HotelData;
import com.example.travels_app.model.RecentsData;

import java.util.ArrayList;
import java.util.List;

public class Home_Page extends AppCompatActivity {

    RecyclerView recentRecycler,Hotelrecycler ;
    RecentsAdapte recentsAdapte;
    HotelAdapte hotelAdapte;
    TextView textView8,textView10;
    ImageView home,hotel,account;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_page);
        textView8=findViewById(R.id.textView8);
        textView10=findViewById(R.id.textView10);
        home=findViewById(R.id.home);
        hotel=findViewById(R.id.Hotel);
        account=findViewById(R.id.account);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Page.this, Home_Page.class);
                startActivity(intent);
                finish();
            }
        });

       hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Page.this, HotelaDetails.class);
                startActivity(intent);
                finish();
            }
        });

       account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Page.this, profilDetail.class);
                startActivity(intent);
                finish();
            }
        });



        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Page.this, DetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_Page.this, HotelaDetails.class);
                startActivity(intent);
                finish();
            }
        });



        List<RecentsData> recentsDataList=new ArrayList<>();
        recentsDataList.add(new RecentsData("GOA","India","From $200",R.drawable.goa));
        recentsDataList.add(new RecentsData("ladakh","India","From $300",R.drawable.ladakh));
        recentsDataList.add(new RecentsData("andaman","India","From $400",R.drawable.andaman));
        recentsDataList.add(new RecentsData("kerala","India","From $500",R.drawable.kk));
        recentsDataList.add(new RecentsData("bhutan","India","From $600",R.drawable.bhutan));
        recentsDataList.add(new RecentsData("kashmir","India","From $700",R.drawable.kashmir));

        setRecyclerReceycler(recentsDataList);


        List<HotelData> hotelDataList=new ArrayList<>();
        hotelDataList.add(new HotelData("Grand Hyatt hotel","Goa","$400",R.drawable.hotelgov));
        hotelDataList.add(new HotelData("The Taj Mahal Palace","Mumbai","$500",R.drawable.m));
        hotelDataList.add(new HotelData("The Leela Palace","Udaipur","$600",R.drawable.u));
        hotelDataList.add(new HotelData("The Oberoi","New Delhi","$400",R.drawable.d));
        hotelDataList.add(new HotelData("The Vivanta Dal","Kashmir","$700",R.drawable.k));
        hotelDataList.add(new HotelData("The Samode Haveli","Jaipur","$200",R.drawable.jaypur));

        setHotelrecycler(hotelDataList);


    }
   private void setRecyclerReceycler(List<RecentsData> recentsDataList){

        recentRecycler=findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapte=new RecentsAdapte((Context) this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapte);
   }private  void  setHotelrecycler(List<HotelData> hotelDataList){
        Hotelrecycler = findViewById(R.id.Hotel_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        Hotelrecycler.setLayoutManager(layoutManager);
        hotelAdapte = new HotelAdapte(this,hotelDataList);
        Hotelrecycler.setAdapter(hotelAdapte);
   }
}


