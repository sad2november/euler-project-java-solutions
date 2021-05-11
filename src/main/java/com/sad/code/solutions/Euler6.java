package com.sad.code.solutions;

import java.math.BigInteger;

/**
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is .
 * <p>
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 */
public class Euler6 {

    public static void main(String[] args) {
        BigInteger sumOfSquares = BigInteger.ZERO;
        BigInteger squareOfSum = BigInteger.ZERO;

        for (int i = 1; i <= 100; i++) {
            sumOfSquares = sumOfSquares.add(new BigInteger("" + i).pow(2));
            squareOfSum = squareOfSum.add(new BigInteger("" + i));
        }

        squareOfSum = squareOfSum.pow(2);
        System.out.println("Result: " + squareOfSum.subtract(sumOfSquares).toString());
    }

}