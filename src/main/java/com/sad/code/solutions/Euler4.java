package com.sad.code.solutions;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler4 {

    public static void main(String[] args) {
        int palindrome = Integer.MIN_VALUE;

        for (int i = 999; i >= 900; i--) {
            for (int j = 999; j >= 900; j--) {
                final String candidate = String.valueOf(i * j);
                final String reverted = new StringBuilder(candidate).reverse().toString();
                if (candidate.equals(reverted) && palindrome < Integer.parseInt(candidate)) {
                    palindrome = Integer.parseInt(candidate);
                }
            }
        }
        System.out.println(palindrome);
    }

}