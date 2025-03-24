package com.example.admin2;

public class bookindataclass {

    private String name;
    private String email;
    private String number;
    private String hotelname;
    private String AdharcardNumber;
    private String set_CheckInDate;
    private String set_CheckOutDate;
    private String set_time;


    public bookindataclass() {
    }

    public void setName(String name) {
        this.name = name;
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

    public bookindataclass(String name, String email, String number, String hotelname, String adharcardNumber, String set_CheckInDat, String set_CheckOutDate, String set_time) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.hotelname = hotelname;
        this.AdharcardNumber = adharcardNumber;
        this.set_CheckInDate = set_CheckInDat;
        this.set_CheckOutDate = set_CheckOutDate;
        this.set_time = set_time;
    }
}


