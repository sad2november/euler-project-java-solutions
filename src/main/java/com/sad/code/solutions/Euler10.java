package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * </p>
 * Find the sum of all the primes below two million.
 */
@Component
public class Euler10 {

    @LogTimer
    @Attachment
    @Step("Getting sum of all primes before {value}")
    public long sieveSolution(final long value) {
        return new Euler3().getPrimes(value)
                .stream()
                .reduce(0L, Long::sum);
    }
}