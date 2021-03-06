package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.var;
import org.springframework.stereotype.Component;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * </p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
@Component
public class Euler2 {

    @LogTimer
    @Attachment
    @Step("Getting sum of the even-valued under {untilValue}")
    public long smallCacheSolution(final long untilValue) {
        var first = 1L;
        var second = 2L;
        var third = first + second;

        long sum = 2L;

        while (true) {
            first = second;
            second = third;
            third = first + second;

            if (third % 2 == 0) {
                sum += third;
            }

            if (third >= untilValue) {
                return sum;
            }
        }
    }
}
