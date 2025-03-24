package com.example.travels_app.model;

import android.widget.EditText;
import android.widget.TextView;

public class Databook {
    private String name;
    private String email;
    private String number;
    private String hotelname;
    private String AdharcardNumber;
    private String set_CheckInDate;
    private String set_CheckOutDate;
    private String set_time;

    public Databook () {
    }

    public Databook (EditText name, EditText email, EditText number, EditText hotelname, EditText AdharcardNumbe,EditText set_CheckOutDate,EditText set_time,TextView set_CheckInDate) {
    }

    public Databook (String newName, String newEmail, String newNumber, String newhotelname, String newAdharcardNumbe, String newset_CheckOutDate,String set_time,String set_CheckInDate) {
    }
    public String getRef_id() {
        return Ref_id;
    }
    private  String Ref_id;


    public void setRef_id(String ref_id) {
        Ref_id = ref_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getHotelname() {
        return hotelname;
    }

    public String getAdharcardNumber() {
        return AdharcardNumber;
    }

    public String getSet_CheckInDate() {
        return set_CheckInDate;
    }

    public String getSet_CheckOutDate() {
        return set_CheckOutDate;
    }

    public String getSet_time() {
        return set_time;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public void setAdharcardNumber(String adharcardNumber) {
        AdharcardNumber = adharcardNumber;
    }

    public void setSet_CheckInDate(String set_CheckInDate) {
        this.set_CheckInDate = set_CheckInDate;
    }

    public void setSet_CheckOutDate(String set_CheckOutDate) {
        this.set_CheckOutDate = set_CheckOutDate;
    }

    public void setSet_time(String set_time) {
        this.set_time = set_time;
    }

    public Databook(String name, String email, String number, String hotelname, String adharcardNumber, String set_CheckInDat,String set_CheckOutDate,String set_time,String ref_id) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.hotelname = hotelname;
        this.AdharcardNumber = adharcardNumber;
        this.set_CheckInDate = set_CheckInDat;
        this.set_CheckOutDate = set_CheckOutDate;
        this.set_time=set_time;
        this.Ref_id= ref_id;

    }
}
