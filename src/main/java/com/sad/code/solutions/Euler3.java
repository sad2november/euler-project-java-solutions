package com.sad.code.solutions;

import java.util.HashMap;
import java.util.Set;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler3 {

    public static void main(String[] args) {
        long timeStart = System.nanoTime();

        long target = 600851475143L;
        Set<Long> primes = Euler3.getPrimes(Math.round(Math.sqrt(target)));

        long largest = Long.MIN_VALUE;
        for (Long iterator : primes) {
            if (target % iterator == 0 && largest < iterator) {
                largest = iterator;
            }
        }

        System.out.println("Result: " + largest);
        System.out.println("Time with siege: " + (System.nanoTime() - timeStart) / 1000L);
    }

    public static Set<Long> getPrimes(final long maxPrimeNum) {
        //Creating hashmap container
        HashMap<Long, Boolean> primes = new HashMap<>();

        //Filling container
        for (long i = 2L; i < maxPrimeNum; i++) {
            primes.put(i, true);
        }

        //Removing non-primes
        for (long i = 2L; i < maxPrimeNum; i++) {
            if (primes.containsKey(i) && primes.get(i)) {
                for (long j = i * i; j < maxPrimeNum; j += i) {
                    primes.remove(j);
                }
            }
        }

        //Removing hashmap and creating list
        return primes.keySet();
    }
}