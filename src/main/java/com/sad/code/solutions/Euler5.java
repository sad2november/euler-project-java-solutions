package com.sad.code.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Euler5 {

    public static void main(String[] args) {
        long maxPrimeNumber = 20L;
        //Getting all primes below value
        Set<Long> primes = new Euler3().getPrimes(maxPrimeNumber);
        List<Long> divisors = new ArrayList<>(primes);

        for (int i = 2; i < maxPrimeNumber; i++) {
            //Looking for prime factors for each number
            List<Long> primeFactors = findPrimeFactors(i);
            //Filtering them to unique list
            Set<Long> nonDuplicatedPrimeFactors = new HashSet<>(primeFactors);

            for (Long factor : nonDuplicatedPrimeFactors) {
                //Now we already have prime numbers, so we need to multiple them
                //For example we have [2, 3, 5, 7]
                //To have simple divisors for factor = 8 we need to have [2, 2, 2, 3, 5, 7] => 2*2*2=8
                //This part multiple [2, ...] to [2, 2, 2 ...] for this example

                long factorsCountWeAlreadyHave = countNumbersInList(factor, divisors);
                long factorsCountWeShouldHave = countNumbersInList(factor, primeFactors);
                while (factorsCountWeAlreadyHave < factorsCountWeShouldHave) {
                    divisors.add(factor);
                    factorsCountWeAlreadyHave++;
                }
            }
        }

        long result = 1L;
        for (Long iterator : divisors) {
            result *= iterator;
        }

        System.out.println("Result: " + result);
    }

    public static List<Long> findPrimeFactors(long num) {
        List<Long> list = new ArrayList<>();
        for (long n = 2; n <= num; n++) {
            while (num % n == 0) {
                list.add(n);
                num = num / n;
            }
        }
        return list;
    }

    public static long countNumbersInList(final long numberToCount, final List<Long> list) {
        long result = 0L;
        for (Long iterator : list.stream().sorted().collect(Collectors.toList())) {
            if (numberToCount == iterator) {
                result++;
            }
            if (iterator > numberToCount) {
                break;
            }
        }
        return result;
    }
}