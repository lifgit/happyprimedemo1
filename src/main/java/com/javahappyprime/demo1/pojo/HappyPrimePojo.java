package com.javahappyprime.demo1.pojo;

public class HappyPrimePojo {

    private int testNum;

    private boolean isHappyPrime;

    public HappyPrimePojo(int testNum, boolean isHappyPrime) {
        this.testNum = testNum;
        this.isHappyPrime = isHappyPrime;
    }

    public int getTestNum() {
        return testNum;
    }

    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    public boolean isHappyPrime() {
        return isHappyPrime;
    }

    public void setHappyPrime(boolean happyPrime) {
        isHappyPrime = happyPrime;
    }
}
