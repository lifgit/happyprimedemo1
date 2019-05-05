package com.javahappyprime.demo1;

import com.javahappyprime.demo1.utilities.NumUtil;
import com.javahappyprime.demo1.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Demo1Controller {

    @Autowired
    RandomNumberService randomNumberService;

    @RequestMapping("/checkHappyPrime")
    @ResponseBody
    public Result checkHappyPrime(@RequestParam(name="testNum", required=false, defaultValue="-1") Integer testNum) {
        int number = testNum;
        if (number == -1) {
            number = randomNumberService.getRandomNumber();
        }
        boolean isHappy = NumUtil.isHappy(number);
        boolean isPrime = NumUtil.isPrime(number);

        return new Result(number, isHappy&&isPrime);
    }
}