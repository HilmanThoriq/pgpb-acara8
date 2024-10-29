package com.example.simpleapp7;

public class Disaster {

    private String disasterName;
    public String getDisasterName(){ return disasterName; }
    public String getDisasterType(){ return disasterType; }

    public void setDisasterName(String disasterName) { this.disasterName = disasterName; }

    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }

    private String disasterType;

    public Disaster(String name, String type){
        this.disasterName = name;
        this.disasterType = type;
    }

}
