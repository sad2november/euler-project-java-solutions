package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Step;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
@Component
public class Euler4 {

    @LogTimer
    @Step("Finding largest palindrome from product numbers under {value}")
    public long bruteForceSolution(final long value) {
        long palindrome = Long.MIN_VALUE;
        val checked = new ArrayList<Long>();

        for (long i = value; i >= value - 200; i--) {
            for (long j = value; j >= value - 200; j--) {
                if (!checked.contains(j)) {
                    val candidate = String.valueOf(i * j);
                    if (candidate.equals(new StringBuilder(candidate).reverse().toString())) {
                        val parsedLong = Long.parseLong(candidate);
                        if (parsedLong > palindrome) {
                            palindrome = parsedLong;
                        }
                    }
                }
            }
            checked.add(i);
        }

        return palindrome == Long.MIN_VALUE ? 0 : palindrome;
    }
}