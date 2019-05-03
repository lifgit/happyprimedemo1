package com.javahappyprime.demo1.services;

import org.springframework.http.ResponseEntity;

public interface HttpClientService {
    ResponseEntity<String> getRandomNumber(String baseurl);
}