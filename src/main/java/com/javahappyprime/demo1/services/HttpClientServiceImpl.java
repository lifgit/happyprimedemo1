package com.javahappyprime.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HttpClientServiceImpl implements HttpClientService {
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> getRandomNumber(String baseUrl) {
        URI uri;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        try{
            ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
            return response;
        }
        catch(ResourceAccessException e){
            return new ResponseEntity<String>(
                    "Resource not found.",
                    HttpStatus.NOT_FOUND
            );
        }
    }
}