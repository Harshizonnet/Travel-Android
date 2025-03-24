package com.example.travels_app.model;

public class RecentsData {
    String placename;
    String countryname;
    String price;
    Integer imgeurl;

    public Integer getImgeurl() {
        return imgeurl;
    }

    public void setImgeurl(Integer imgeurl) {
        this.imgeurl = imgeurl;
    }

    public RecentsData(String placename, String countryname, String price, Integer imgeurl){
        this.placename=placename;
        this.countryname=countryname;
        this.price=price;
        this.imgeurl=imgeurl;


    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

