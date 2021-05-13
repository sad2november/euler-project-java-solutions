package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.val;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
@Component
public class Euler5 {

    @LogTimer
    @Attachment
    @Step("Finding smallest positive number that is evenly divisible by all of the numbers from 1 to {maxValue}")
    public String solution(final int maxValue) {
        //Getting all primes below value
        val divisors = new ArrayList<Long>();

        IntStream.rangeClosed(2, maxValue).forEach(x -> {
            //Looking for prime factors for each number
            val primeFactors = findPrimeFactors(x);

            //Filtering them to unique list
            primeFactors.stream().distinct().forEach(y -> {
                //Now we already have prime numbers, so we need to multiple them
                //For example we have [2, 3, 5, 7]
                //To have simple divisors for factor = 8 we need to have [2, 2, 2, 3, 5, 7] => 2*2*2=8
                //This part multiple [2, ...] to [2, 2, 2 ...] for this example

                long factorsCountWeAlreadyHave = countNumbersInList(y, divisors);
                long factorsCountWeShouldHave = countNumbersInList(y, primeFactors);

                while (factorsCountWeAlreadyHave < factorsCountWeShouldHave) {
                    divisors.add(y);
                    factorsCountWeAlreadyHave++;
                }
            });
        });

        if (maxValue <= 40) {
            return divisors.stream().reduce(1L, (total, x) -> total *= x).toString();
        } else {
            val result = new AtomicReference<>(BigInteger.ONE);
            divisors.forEach(x -> result.set(result.get().multiply(new BigInteger(x.toString()))));
            return result.toString();
        }
    }

    public List<Long> findPrimeFactors(long num) {
        List<Long> list = new ArrayList<>();
        for (long n = 2; n <= num; n++) {
            while (num % n == 0) {
                list.add(n);
                num = num / n;
            }
        }
        return list;
    }

    public long countNumbersInList(final long numberToCount, final List<Long> list) {
        return list.stream().filter(x -> x == numberToCount).count();
    }
}