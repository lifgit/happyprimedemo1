package com.javahappyprime.demo1.controller_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javahappyprime.demo1.aop.CustomResponse;
import com.javahappyprime.demo1.vo.HappyPrimeView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HappyPrimeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCheckHappyPrime() throws Exception {
        HappyPrimeView happyPrime = new HappyPrimeView();
        happyPrime.setTestNum(1);
        happyPrime.setHappyPrime(false);
        CustomResponse expectResult = new CustomResponse(happyPrime);

        mockMvc.perform(get("/v1/checkHappyPrime/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expectResult)));
    }
}
