package com.javahappyprime.demo1;

public class Result {

    private final int testNum;
    private final Boolean isHappyPrime;

    public Result(int testNum, boolean isHappyPrime) {
        this.testNum = testNum;
        this.isHappyPrime = isHappyPrime;
    }

    public int getTestNum() {
        return testNum;
    }

    public Boolean getIsHappyPrime() {
        return isHappyPrime;
    }

}