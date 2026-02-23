package com.simonpeg.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class WhatsappService {
    private final RestTemplate restTemplate = new RestTemplate();

    public void sendMessage(String number, String message){

        String url = "https://api.fonnte.com/send";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "TOKEN_ANDA");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,String> body = new HashMap<>();
        body.put("target", number);
        body.put("message", message);

        HttpEntity<Map<String,String>> request = new HttpEntity<>(body, headers);

        restTemplate.postForEntity(url, request, String.class);
    }
}
