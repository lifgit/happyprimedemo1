package com.javahappyprime.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    @Value("${apiurl}")
    private String randomServiceUrl;

    @Autowired
    HttpClientService httpClient;

    public int getRandomNumber(){
        ResponseEntity<String> response = httpClient.getRandomNumber(randomServiceUrl);
        try{
            int number = Integer.parseInt(response.getBody().trim());
            return number;
        }
        catch (NumberFormatException e){
            return 0;
        }
    }
}