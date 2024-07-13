package com.example.sportfinder.data.localdatabase;

public class SpotItem {

    private int id;
    private String spotName;
    private String flagImage;


    public SpotItem(int id, String spotName, String flagImage) {
        this.id = id;
        this.spotName = spotName;
        this.flagImage = flagImage;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }
    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public String getFlagImage() {
        return flagImage;
    }

    @Override
    public String toString() {
        return "SpotItem{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                ", flagImage='" + flagImage + '\'' +
                '}';
    }
}