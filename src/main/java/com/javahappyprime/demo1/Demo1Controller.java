package com.javahappyprime.demo1;

import com.javahappyprime.demo1.utilities.NumUtil;
import com.javahappyprime.demo1.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/checkHappyPrime")
public class Demo1Controller {

    @Autowired
    RandomNumberService randomNumberService;

    @RequestMapping(value = {"", "/{testNum}"}, method = RequestMethod.GET )
    @ResponseBody
    public Result checkHappyPrime(@PathVariable(name="testNum", required=false) Integer testNum) {
        if (testNum == null) {
            testNum = randomNumberService.getRandomNumber();
        }
        boolean isHappy = NumUtil.isHappy(testNum);
        boolean isPrime = NumUtil.isPrime(testNum);

        return new Result(testNum, isHappy&&isPrime);
    }
}