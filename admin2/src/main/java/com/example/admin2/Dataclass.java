package com.example.admin2;

public class Dataclass {
    private String fileName;
    private String imageUrl,about,name,price,Location;
    private String nodeId;

    public Dataclass(String fileName, String imageUrl) {
        this.fileName = fileName;
        this.imageUrl = imageUrl;
    }

    public Dataclass() {
    }

    public Dataclass(String fileName, String imageUrl, String about, String name, String price) {
        this.fileName = fileName;
        this.imageUrl = imageUrl;
        this.Location = Location;
        this.about = about;
        this.name = name;
        this.price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
}
}

