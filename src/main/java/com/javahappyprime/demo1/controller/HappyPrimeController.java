package com.javahappyprime.demo1.controller;

import com.javahappyprime.demo1.converter.PojoConverter;
import com.javahappyprime.demo1.pojo.HappyPrimePojo;
import com.javahappyprime.demo1.service.HappyPrimeService;
import com.javahappyprime.demo1.vo.HappyPrimeView;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/checkHappyPrime")
public class HappyPrimeController {

    @Autowired
    private HappyPrimeService happyPrimeService;

    @Autowired
    private PojoConverter<HappyPrimeView, HappyPrimePojo> simpleConverter;

    @RequestMapping(value = {"", "/{testNum}"}, method = RequestMethod.GET )
    @ResponseBody
    public HappyPrimeView checkHappyPrime(@PathVariable(name="testNum", required=false) Integer testNum) {
        HappyPrimePojo happyPrimePojo = happyPrimeService.checkHappyPrime(testNum);
        HappyPrimeView happyPrimeView = new HappyPrimeView();
        simpleConverter.toVo(happyPrimePojo, happyPrimeView);
        return happyPrimeView;
    }
}