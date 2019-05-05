package com.javahappyprime.demo1.service_test;

import com.javahappyprime.demo1.exception.BizarreException;
import com.javahappyprime.demo1.service.RemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoteServiceTest {

    @Value("${app.random.number.api}")
    String randomNumberApi;

    @Autowired
    RemoteService remoteService;

    @MockBean
    RestTemplate restTemplate;

    @Test
    public void testGetRandomNumberForValidNumber()
    {
        ResponseEntity<String> response =  new ResponseEntity<String>("2", HttpStatus.OK);
        when(restTemplate.getForEntity(randomNumberApi, String.class)).thenReturn(response);

        Integer randomNumber = remoteService.getRandomNumber();
        assertEquals(2, randomNumber.intValue());
    }

    @Test
    public void testGetRandomNumberForInvalidNumber()
    {
        ResponseEntity<String> response =  new ResponseEntity<String>("1ab2", HttpStatus.OK);
        when(restTemplate.getForEntity(randomNumberApi, String.class)).thenReturn(response);
        try {
            remoteService.getRandomNumber();
        } catch (Exception ex) {
            assertTrue(ex instanceof BizarreException);
        }
    }

    @Test
    public void testGetRandomNumberForEmptyBody()
    {
        ResponseEntity<String> response =  new ResponseEntity<String>("", HttpStatus.OK);
        when(restTemplate.getForEntity(randomNumberApi, String.class)).thenReturn(response);

        Integer randomNumber = remoteService.getRandomNumber();
        assertNull(randomNumber);
    }
}
