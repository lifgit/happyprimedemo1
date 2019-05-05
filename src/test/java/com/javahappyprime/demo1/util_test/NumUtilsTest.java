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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NumUtilsTest {
    public static List<TestData> testDataList;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
        DataLoader dataLoader = new DataLoader();
        testDataList = dataLoader.loadObjectList(TestData.class, "testData.csv");
        for (TestData tData : testDataList) {
            System.out.println( "tdata" + tData.getTestNum() + tData.getIsPrime() + tData.getIsHappy());
        }

    }

    @Test
    public void testPrimeNumbers() {
        System.out.println("Test1");
        assertEquals(true, NumUtils.isPrime(137));
        assertEquals(false, NumUtils.isPrime(138));

    }

    @Test
    public void testHappyNumbers() {
        System.out.println("Test2");
        assertEquals(true, NumUtils.isHappy(167));
        assertEquals(false, NumUtils.isHappy(168));
    }

    @Test
    public void testCSVData() {
        System.out.println("Test3");
        for ( TestData tData : testDataList) {
            assertEquals(tData.getIsHappy(), NumUtils.isHappy(tData.getTestNum()));
            assertEquals(tData.getIsPrime(), NumUtils.isPrime(tData.getTestNum()));
        }
    }

    @Test
    public void shouldReturnCorrectIsHappyPositive() {
        System.out.println("Test4");
        assertThat(NumUtils.isHappy(1), is(true));
        assertThat(NumUtils.isHappy(100), is(true));
        assertThat(NumUtils.isHappy(21), is(false));
        assertThat(NumUtils.isHappy(210000), is(false));
        assertThat(NumUtils.isHappy(987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsHappyNegative() {
        System.out.println("Test5");
        assertThat(NumUtils.isHappy(-1), is(false));
        assertThat(NumUtils.isHappy(-100), is(false));
        assertThat(NumUtils.isHappy(-21), is(false));
        assertThat(NumUtils.isHappy(-210000), is(false));
        assertThat(NumUtils.isHappy(-987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimePositive() {
        System.out.println("Test6");
        assertThat(NumUtils.isPrime(1), is(false));
        assertThat(NumUtils.isPrime(17), is(true));
        assertThat(NumUtils.isPrime(21), is(false));
        assertThat(NumUtils.isPrime(210000), is(false));
        assertThat(NumUtils.isPrime(987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimeNegative() {
        System.out.println("Test7");
        assertThat(NumUtils.isPrime(-1), is(false));
        assertThat(NumUtils.isPrime(-100), is(false));
        assertThat(NumUtils.isPrime(-21), is(false));
        assertThat(NumUtils.isPrime(-210000), is(false));
        assertThat(NumUtils.isPrime(-987654321), is(false));
    }

    @Test
    public void shouldReturnCorrectIsHappyZero() {
        System.out.println("Test8");
        assertThat(NumUtils.isHappy(0), is(false));
    }

    @Test
    public void shouldReturnCorrectIsPrimeZero() {
        System.out.println("Test9");
        assertThat(NumUtils.isPrime(0), is(false));
    }
}
