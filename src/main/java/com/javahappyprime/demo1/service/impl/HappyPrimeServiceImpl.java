package com.javahappyprime.demo1.service.impl;

import com.javahappyprime.demo1.exception.BizarreException;
import com.javahappyprime.demo1.exception.ErrorCode;
import com.javahappyprime.demo1.pojo.HappyPrimePojo;
import com.javahappyprime.demo1.service.HappyPrimeService;
import com.javahappyprime.demo1.service.RemoteService;
import com.javahappyprime.demo1.util.NumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HappyPrimeServiceImpl implements HappyPrimeService {
    private final static Logger LOGGER = LoggerFactory.getLogger(HappyPrimeServiceImpl.class);

    @Autowired
    private RemoteService remoteService;

    @Override
    public HappyPrimePojo checkHappyPrime(Integer testNum) {
        if (testNum == null) {
            testNum = remoteService.getRandomNumber();
            if (testNum == null) {
                LOGGER.error("Got null for random number.");
                throw new BizarreException(ErrorCode.INVALID_NUMBER, "Got null for random number.");
            }
        }

        boolean isPrime = NumUtils.isPrime(testNum);
        if (isPrime) {
            boolean isHappy = NumUtils.isHappy(testNum);
            return new HappyPrimePojo(testNum, isHappy);
        }
        return new HappyPrimePojo(testNum, false);
    }
}
