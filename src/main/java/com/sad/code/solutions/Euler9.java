package com.sad.code.solutions;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Euler9 {

    public static void main(String[] args) {

        for (int a = 2; a < 500; a++) {
            int a2 = a * a;
            for (int b = a; b > 1; b--) {
                int b2 = b * b;
                int probableC2 = a2 + b2;
                int probableC = (int) Math.round(Math.sqrt(probableC2));

                if (a + b + probableC == 1000) {
                    System.out.println(a * b * probableC);
                    break;
                }
            }
        }
    }
}