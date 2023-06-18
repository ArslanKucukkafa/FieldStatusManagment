package com.example.tarlascraping1.Models.ScrapingResponse;

import com.example.tarlascraping1.Models.Properties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FieldModel {

    private String type;
    private Geometry geometry;
    private Properties properties;

    public String ffff (){
        return properties.getIlAd();
    }
}

class Geometry{
    private String type;
    private int [][] coordinates;
}

