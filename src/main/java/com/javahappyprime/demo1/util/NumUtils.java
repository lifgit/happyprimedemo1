package com.javahappyprime.demo1.util;

import java.util.HashSet;
import java.util.Set;

public class NumUtils {
    public static boolean isHappy(int num){
        if (num < 1){
            return false;
        }
        Set<Integer> unique_num = new HashSet<Integer>();

        while (unique_num.add(num))
        {
            int value = 0;
            while (num > 0)
            {
                value += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = value;
        }

        return num == 1;
    }

    public static boolean isPrime(int num) {
        if (num <= 1 ) return false;

        // check from 2 to num-1
        for ( int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}