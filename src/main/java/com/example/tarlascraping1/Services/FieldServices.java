package com.example.tarlascraping1.Services;
import com.example.tarlascraping1.Models.FieldProcessModel;
import com.example.tarlascraping1.Models.Properties;
import com.example.tarlascraping1.Repository.FieldProcessRepository;
import com.example.tarlascraping1.Repository.PropertiesRepository;
import com.example.tarlascraping1.WebclientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FieldServices {
    @Autowired
    private WebclientImpl webclient;
    @Autowired
    private PropertiesRepository propertiesRepository;
    @Autowired
    private FieldProcessRepository fieldProcessRepository;

    public ResponseEntity saveFile(){
        Properties properties = webclient.properties("40.572674163586534","34.93722830618714");
        propertiesRepository.save(properties);
        return new ResponseEntity(HttpStatus.OK);
    }


    public ResponseEntity saveProcess(FieldProcessModel fieldProcessModel, int id){
        Properties properties = propertiesRepository.findByPropertiesId(id);
        fieldProcessModel.setProperties(properties);
        fieldProcessRepository.save(fieldProcessModel);
        return new ResponseEntity(HttpStatus.OK);
    }

    public Map<String, String> getRate(){
        return webclient.getRate();
    }
}
