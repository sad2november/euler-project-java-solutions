package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @see <a href=https://projecteuler.net/problem=1>Problem1</a>
 */
@Component
public class Euler1 {

    @LogTimer
    @Attachment
    @Step("Getting sum of multiples 3 or 5 from 1 to {maxValue} with brute force")
    public long bruteForceSolution(final long maxValue) {
        return LongStream.range(3L, maxValue)
                .parallel()
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .reduce(0, Long::sum);
    }

    @LogTimer
    @Step("Getting sum of multiples 3 or 5 from 1 to {maxValue} with sum of arithmetic progression")
    public long smartSolution(final long maxValue) {
        //sum of arithmetic progression with step 3
        long a1 = 3L;
        long n1 = (maxValue - 1) / a1;
        long a2 = a1 * n1;
        double sum1 = ((a1 + a2) * n1) / 2.0d;
        //sum of arithmetic progression with step 5
        long b1 = 5L;
        long n2 = (maxValue - 1) / 5L;
        long b2 = b1 * n2;
        double sum2 = ((b1 + b2) * n2) / 2.0d;
        //sum of arithmetic progression with step 3 * 5
        long c1 = a1 * b1;
        long n3 = (maxValue - 1) / c1;
        long c2 = c1 * n3;
        double sum3 = ((c1 + c2) * n3) / 2.0d;

        return (long) (sum1 + sum2 - sum3);
    }
}