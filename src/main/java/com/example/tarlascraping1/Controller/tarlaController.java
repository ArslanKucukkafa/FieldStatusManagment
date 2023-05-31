package com.example.tarlascraping1.Controller;

import com.example.tarlascraping1.Models.coordinateModel;
import com.example.tarlascraping1.WebclientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/")
public class tarlaController {
    @Autowired
    private WebclientImpl webclient;
    @GetMapping("Hello")
    public ResponseEntity getToken() {
    return webclient.properties("40.572674163586534","34.93722830618714");
    }
}
