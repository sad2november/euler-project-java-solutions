package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * Let us list the factors of the first seven triangle numbers:
 * <p>
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 * <p>
 * What is the value of the first triangle number to have over five hundred divisors?
 */
@Component
public class Euler12 {

    @LogTimer
    @Attachment
    @Step("Finding the value of the first triangle number to have over {overDivisorsNumber} divisors")
    public long bruteforceSolution(final int overDivisorsNumber) {
        var lastChecked = 1L;
        var divisorsCount = 0;

        for (long i = 2L; divisorsCount < overDivisorsNumber; i++) {
            lastChecked += i;
            val temp = lastChecked;

            divisorsCount = (int) LongStream.rangeClosed(2L, Math.round(Math.sqrt(lastChecked)))
                    //looking on factors before sqrt because another factors greater than sqrt would be a mirror
                    .parallel()
                    .filter(x -> temp % x == 0)
                    .count() * 2; //mirror factors we would count as *2 like (2 and 8 || 8 and 2)
        }

        return lastChecked;
    }
}