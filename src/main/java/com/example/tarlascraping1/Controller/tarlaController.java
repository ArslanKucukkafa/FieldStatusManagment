package com.example.tarlascraping1.Controller;

import com.example.tarlascraping1.Models.FieldProcessModel;
import com.example.tarlascraping1.Models.Properties;
import com.example.tarlascraping1.ModelsDTO.FieldProccesDTO;
import com.example.tarlascraping1.Services.FieldServices;
import com.example.tarlascraping1.WebclientImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/")
public class tarlaController {
    @Autowired
    private WebclientImpl webclient;

    @Autowired
    private FieldServices services;
    @GetMapping("Hello")
    public Properties getToken() {
    return webclient.properties("40.572674163586534","34.93722830618714");
    }

    @PostMapping("saveField")
    public ResponseEntity saveField(){
    return services.saveFile();}

    @PostMapping("saveProcess")
    public ResponseEntity saveProcess(@RequestBody FieldProccesDTO fieldProccesDTO){
        return services.saveProcess(fieldProccesDTO.FieldProccesDTOMapping(fieldProccesDTO),1);}

    @GetMapping("getRate")
    public Map<String, String> getRate(){
        return services.getRate();
    }
}
