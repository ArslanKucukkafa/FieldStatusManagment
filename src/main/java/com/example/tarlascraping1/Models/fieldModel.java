package com.example.tarlascraping1.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

@Getter
@Setter
public class fieldModel {
    private String type;
    private Geometry geometry;
    private properties properties;


    public String ffff (){
        return properties.getIlAd();
    }
}


class Geometry{
    private String type;
    private int [][] coordinates;}

@Data
 class properties{

    private String ilceAd;
    private String mevkii;
    private String parselNo;
    private String nitelik;
    private String mahalleAd;
    private String alan;
    private String adaNo;
    private String ilAd;
    private String pafta;
}
