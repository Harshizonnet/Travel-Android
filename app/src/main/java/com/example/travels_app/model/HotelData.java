package com.example.travels_app.model;

public class HotelData {
    String Hotelname;
    String placename;
    String price;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HotelData(String hotelname, String placename, String price, Integer imageUrl) {
        Hotelname = hotelname;
        this.placename = placename;
        this.price = price;
        this.imageUrl=imageUrl;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
