package com.sad.code.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Euler7 {

    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);

        for (long i = 3L; primes.size() != 10001; i++) {
            final long primeCandidate = i;
            if (primes.stream().parallel().noneMatch(prime -> primeCandidate % prime == 0)) {
                primes.add(i);
            }
        }

        System.out.println("10001st prime number: " + primes.get(10000));
    }
}