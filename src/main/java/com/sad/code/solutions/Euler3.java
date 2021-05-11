package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Set;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * </p>
 * What is the largest prime factor of the number 600851475143 ?
 */
@Component
public class Euler3 {

    //Max integer value 2147483647
    //Problem value     600851475143
    @LogTimer
    @Attachment
    @Step("Finding largest prime factor of the number {value} with sieve primes solution and brute force")
    public long sieveSolution(final long value) {
        val primes = getPrimes(Math.round(Math.sqrt(value)));

        var temp = value;
        var largest = Long.MIN_VALUE;

        for (Long iterator : primes) {
            while (temp % iterator == 0) {
                temp /= iterator;
                if (largest < iterator) {
                    largest = iterator;
                }
            }
        }

        return largest == Long.MIN_VALUE ? value : largest;
    }

    @LogTimer
    @Attachment
    @Step("Finding largest prime factor of the number {value} with brute force")
    public long bruteForceSolution(final long value) {
        var largest = Long.MIN_VALUE;
        var temp = value;

        for (long i = 2L; i <= Math.round(Math.sqrt(value)) + 1; i++) {
            while (temp % i == 0) {
                temp /= i;
                if (largest < i) {
                    largest = i;
                }
            }
        }

        return largest == Long.MIN_VALUE ? value : largest;
    }

    /**
     * Creating set with primes with sieve of eratosthenes
     *
     * @param maxValue under this value creating primes, probably need to send here Math.sqrt(value)
     * @return set with primes
     */
    @LogTimer
    public Set<Long> getPrimes(final long maxValue) {
        val stopWatch = new StopWatch("primes sieve");
        stopWatch.start();

        //Creating hashmap container, because we cant create list or array with long type size
        val primes = new HashMap<Long, Boolean>();

        //Filling container
        for (long i = 2L; i <= maxValue; i++) {
            primes.put(i, true);
        }

        //Removing non-primes
        for (long i = 2L; i <= maxValue; i++) {
            if (primes.containsKey(i) && primes.get(i)) {
                for (long j = i * i; j <= maxValue; j += i) {
                    primes.remove(j);
                }
            }
        }

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        //Removing hashmap
        return primes.keySet();
    }
}