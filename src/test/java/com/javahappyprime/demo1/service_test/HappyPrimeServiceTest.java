package com.javahappyprime.demo1.service_test;

import com.javahappyprime.demo1.exception.BizarreException;
import com.javahappyprime.demo1.exception.ErrorCode;
import com.javahappyprime.demo1.pojo.HappyPrimePojo;
import com.javahappyprime.demo1.service.HappyPrimeService;
import com.javahappyprime.demo1.service.RemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HappyPrimeServiceTest {

    @Autowired
    HappyPrimeService happyPrimeService;

    @MockBean
    RemoteService remoteService;

    @Test
    public void testCheckHappyPrimeWithSpecifiedNumber()
    {
        HappyPrimePojo happyPrimeOne = happyPrimeService.checkHappyPrime(1);
        assertEquals(1, happyPrimeOne.getTestNum());
        assertEquals(false, happyPrimeOne.isHappyPrime());

        HappyPrimePojo happyPrimeTwo = happyPrimeService.checkHappyPrime(2);
        assertEquals(2, happyPrimeTwo.getTestNum());
        assertEquals(false, happyPrimeTwo.isHappyPrime());

        HappyPrimePojo happyPrimeSeven = happyPrimeService.checkHappyPrime(7);
        assertEquals(7, happyPrimeSeven.getTestNum());
        assertEquals(true, happyPrimeSeven.isHappyPrime());
    }

    @Test
    public void testCheckHappyPrimeWithRandomNumber()
    {
        when(remoteService.getRandomNumber()).thenReturn(7);
        HappyPrimePojo happyPrimeSeven = happyPrimeService.checkHappyPrime(null);
        assertEquals(7, happyPrimeSeven.getTestNum());
        assertEquals(true, happyPrimeSeven.isHappyPrime());

        when(remoteService.getRandomNumber()).thenReturn(2);
        HappyPrimePojo happyPrimeTwo = happyPrimeService.checkHappyPrime(null);
        assertEquals(2, happyPrimeTwo.getTestNum());
        assertEquals(false, happyPrimeTwo.isHappyPrime());

        when(remoteService.getRandomNumber()).thenReturn(null);
        try {
            happyPrimeService.checkHappyPrime(null);
        } catch (Exception ex) {
            assertTrue(ex instanceof BizarreException);
            BizarreException actualEx = (BizarreException) ex;
            BizarreException expectEx = new BizarreException(ErrorCode.INVALID_NUMBER, "Got null for random number.");
            assertEquals(expectEx.getErrorCode(), actualEx.getErrorCode());
            assertEquals(expectEx.getMessage(), actualEx.getMessage());
        }
    }
}
