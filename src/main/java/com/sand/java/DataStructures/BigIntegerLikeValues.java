package com.sand.java.DataStructures;

import java.math.BigInteger;

public class BigIntegerLikeValues {

    public static void main(String[] x) {
        // Write your code here
        int n = 25;
        BigInteger l = BigInteger.valueOf(1);
        while (n!=0) {
            l = l.multiply(BigInteger.valueOf(n));
            n-=1;
        }
        System.out.println(l);

    }
}
