package com.javahappyprime.demo1.service.impl;

import com.javahappyprime.demo1.exception.HappyPrimeException;
import com.javahappyprime.demo1.exception.ErrorCode;
import com.javahappyprime.demo1.service.RemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteServiceImpl implements RemoteService {
    private final static Logger LOGGER = LoggerFactory.getLogger(RemoteServiceImpl.class);

    @Value("${app.random.number.api}")
    private String randomNumberApi;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Integer getRandomNumber() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(randomNumberApi, String.class);
            String result = response.getBody();
            if (!StringUtils.isEmpty(result)) {
                return Integer.parseInt(result.trim());
            }
            return null;
        } catch (Exception ex) {
            LOGGER.error("Get random number failed, cause by:", ex);
            String errorMessage = "Get random number failed, cause by: %s";
            throw new HappyPrimeException(ErrorCode.RANDOM_NUMBER_BAD_REQUEST, String.format(errorMessage, ex.getMessage()));
        }
    }
}
