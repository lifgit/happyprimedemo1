package com.javahappyprime.demo1;

import com.javahappyprime.demo1.utilities.NumUtil;
import com.javahappyprime.demo1.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Demo1Controller {
    private static final String template = "Hello, %s is %s!";

    @Autowired
    RandomNumberService randomNumberService;


    @GetMapping("/checkHappyPrime")
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