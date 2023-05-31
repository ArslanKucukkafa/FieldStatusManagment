package com.example.tarlascraping1.Models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class coordinateModel {

    public coordinateModel (String lat,String lng){
        this.lat=lat;
        this.lng=lng;
    }

    private String lat;
    private String lng;
    private base_params base_params;
}

class base_params{

    private String deviceID=null;
    private String deviceIP="";
    private String i_user="";
    private int pid=1;
    private int plid=3;
    private String ver= "web";
}