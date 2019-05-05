package com.javahappyprime.demo1.testutils;

public class TestData {
    private int testNum;
    private boolean isPrime;
    private boolean isHappy;
    private boolean isHappyPrime;

    public TestData(){
        super();
    }

    public TestData(int testNum, boolean isPrime, boolean isHappy, boolean isHappyPrime) {
        this.testNum = testNum;
        this.isHappy = isHappy;
        this.isPrime = isPrime;
        this.isHappyPrime = isHappyPrime;
    }

    public int getTestNum() {
        return testNum;
    }
    public Boolean getIsHappy() {
        return isHappy;
    }
    public Boolean getIsPrime() {
        return isPrime;
    }
    public Boolean getIsHappyPrime() {
        return isHappyPrime;
    }
}
