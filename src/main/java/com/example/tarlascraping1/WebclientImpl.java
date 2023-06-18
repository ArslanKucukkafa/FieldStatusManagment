package com.example.tarlascraping1;

import com.example.tarlascraping1.Models.ScrapingResponse.FieldModel;
import com.example.tarlascraping1.Models.Properties;
import com.example.tarlascraping1.Models.ScrapingResponse.TokenModel;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class WebclientImpl {

    public void case1(){
        WebClient webClient = WebClient.create("https://www.baeldung.com/spring-5-webclient#3-binding-to-a-web-handler");
        System.out.println(webClient);
    }
    public String token(){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "67e3846244fad760bf17b1811c95eedcea109449ebd780c22736d91f8ac5b230U2FsdGVkX1%2BCz457xDV8FrKn9EbMM48mLJuJy2Qp%2FHAcKt0UOZ1PwHCF3DAS4jv%2FR%2BHjpGTaWl6o0bUzyTzTjA%3D%3D";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.set("host","backbone.tuvimer.com");
        headers.set("referer","https://tapusor.com/");
        headers.setContentLength(164);
        HttpEntity<String> entity = new HttpEntity<String>(uri,headers);
        TokenModel object = restTemplate.exchange("https://backbone.tuvimer.com/v1/micro/getMicroToken", HttpMethod.POST,entity, TokenModel.class).getBody();
        return object.getToken();
    }


    public Properties properties(String lat, String lng){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://micro.tuvimer.com/tkgm/v1/getTKGMInfoCoordinate";
        String token = token();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",token);
        headers.set("host","micro.tuvimer.com");
        headers.set("referer","https://tapusor.com/");
        HashMap<String,Object> map = new HashMap<>();
        map.put("lat",lat);
        map.put("lng",lng);
        HashMap<String,String>map1= new HashMap<>();
        map1.put("deviceID",null);
        map1.put("deviceIP","");
        map1.put("i_user","");
        map1.put("i_userID","");
        map1.put("pid","1");
        map1.put("plid","3");
        map1.put("ver","web");
        map.put("base_params",map1);
        
        HttpEntity<HashMap> entity = new HttpEntity<>(map,headers);
        FieldModel model1 = restTemplate.exchange(url,HttpMethod.POST,entity, FieldModel.class).getBody();
        System.out.println(model1.ffff());
        return model1.getProperties();
    }

    // https://canlidoviz.com/doviz-kurlari/kapali-carsi WİTH ABOUT SCRAPİNG
    public Map<String, String> getRate(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.haremaltin.com/dashboard/ajax/doviz";
        HttpHeaders headers = new HttpHeaders();
        headers.set("host","www.haremaltin.com");
        headers.set("X-Requested-With","XMLHttpRequest");
        HttpEntity<Void>entity = new HttpEntity<>(headers);
        Map<String,Object>object = restTemplate.exchange(url,HttpMethod.POST,entity,Map.class).getBody();
        Map<String,Object>data = (Map<String, Object>) object.get("data");
        JSONObject jsonObject = new JSONObject(data);
        JSONObject usd = jsonObject.getJSONObject("USDTRY");
        JSONObject euro = jsonObject.getJSONObject("EURTRY");
        Map<String,String> rates = new HashMap<>();
        rates.put("usd",usd.getString("satis"));
        rates.put("euro",euro.getString("satis"));
        return rates;
    }

}
