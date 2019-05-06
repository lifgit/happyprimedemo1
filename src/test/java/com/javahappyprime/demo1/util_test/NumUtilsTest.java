package com.javahappyprime.demo1.util_test;

import com.javahappyprime.demo1.util.NumUtils;
import com.javahappyprime.demo1.testutil.DataLoader;
import com.javahappyprime.demo1.testutil.TestData;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NumUtilsTest {
    public static List<TestData> testDataList;

    private final static Logger LOGGER = LoggerFactory.getLogger(NumUtilsTest.class);

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("before class");
        DataLoader dataLoader = new DataLoader();
        testDataList = dataLoader.loadObjectList(TestData.class, "testData.csv");
        String formatter = "tdata:%s, isPrime:%s, isHappy:%s";
        for (TestData tData : testDataList) {
            LOGGER.info(String.format(formatter, tData.getTestNum(), tData.getIsPrime(), tData.getIsHappy()));
        }

    }

    @Test
    public void testPrimeNumbers() {
        LOGGER.info("Test1");
        assertEquals(true, NumUtils.isPrime(137));
        assertEquals(false, NumUtils.isPrime(138));

    }

    @Test
    public void testHappyNumbers() {
        LOGGER.info("Test2");
        assertEquals(true, NumUtils.isHappy(167));
        assertEquals(false, NumUtils.isHappy(168));
    }

    @Test
    public void testCSVData() {
        LOGGER.info("Test3");
        for ( TestData tData : testDataList) {
            assertEquals(tData.getIsHappy(), NumUtils.isHappy(tData.getTestNum()));
            assertEquals(tData.getIsPrime(), NumUtils.isPrime(tData.getTestNum()));
        }
    }

    @Test
    public void shouldReturnCorrectIsHappyPositive() {
        LOGGER.info("Test4");
        assertThat(NumUtils.isHappy(1), is(true));
        assertThat(NumUtils.isHappy(100), is(true));
        assertThat(NumUtils.isHappy(21), is(false));
        assertThat(NumUtils.isHappy(210000), is(false));
        assertThat(NumUtils.isHappy(987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsHappyNegative() {
        LOGGER.info("Test5");
        assertThat(NumUtils.isHappy(-1), is(false));
        assertThat(NumUtils.isHappy(-100), is(false));
        assertThat(NumUtils.isHappy(-21), is(false));
        assertThat(NumUtils.isHappy(-210000), is(false));
        assertThat(NumUtils.isHappy(-987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimePositive() {
        LOGGER.info("Test6");
        assertThat(NumUtils.isPrime(1), is(false));
        assertThat(NumUtils.isPrime(17), is(true));
        assertThat(NumUtils.isPrime(21), is(false));
        assertThat(NumUtils.isPrime(210000), is(false));
        assertThat(NumUtils.isPrime(987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimeNegative() {
        LOGGER.info("Test7");
        assertThat(NumUtils.isPrime(-1), is(false));
        assertThat(NumUtils.isPrime(-100), is(false));
        assertThat(NumUtils.isPrime(-21), is(false));
        assertThat(NumUtils.isPrime(-210000), is(false));
        assertThat(NumUtils.isPrime(-987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsHappyZero() {
        LOGGER.info("Test8");
        assertThat(NumUtils.isHappy(0), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimeZero() {
        LOGGER.info("Test9");
        assertThat(NumUtils.isPrime(0), is(false));
    }
}
