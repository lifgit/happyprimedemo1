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
public class NumUtilTest {
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

    }

    @Test
    public void testHappyNumbers() {
        System.out.println("Test2");
        assertEquals(true, NumUtils.isHappy(167));
    }

    @Test
    public void testCSVData() {
        System.out.println("Test3-start");
        for ( TestData tData : testDataList) {
            System.out.println("Test3:" + tData.getTestNum());
            assertEquals(tData.getIsHappy(), NumUtils.isHappy(tData.getTestNum()));
            assertEquals(tData.getIsPrime(), NumUtils.isPrime(tData.getTestNum()));
        }
        System.out.println("Test3-end");
    }

    @Test
    public void shouldReturnCorrectIsHappyPositive() {
        assertThat(NumUtils.isHappy(1), is(true));
        assertThat(NumUtils.isHappy(100), is(true));
        assertThat(NumUtils.isHappy(7), is(true));
        assertThat(NumUtils.isHappy(167),is(true));
        assertThat(NumUtils.isHappy(2), is(false));
        assertThat(NumUtils.isHappy(20000), is(false));
        assertThat(NumUtils.isHappy(1234567890), is(false));
    }
}
