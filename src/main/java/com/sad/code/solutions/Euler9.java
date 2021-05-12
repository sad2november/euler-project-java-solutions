package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
@Component
public class Euler9 {

    @LogTimer
    @Attachment
    @Step("Getting product of Pythagorean triplet which sum is {sumABC}")
    public int bruteForceSolution(final int sumABC) {
        val product = new AtomicInteger(0);
        val list = IntStream.rangeClosed(1, sumABC - 1).map(x -> x * x).boxed().collect(Collectors.toList());

        list.forEach(i -> list.forEach(j -> {
            if (!i.equals(j)) {
                if (list.contains(i + j) && (Math.sqrt(i) + Math.sqrt(j) + Math.sqrt(i + j) == sumABC)) {
                    product.set((int) (Math.sqrt(i) * Math.sqrt(j) * Math.sqrt(i + j)));
                }
            }
        }));

        return product.get();
    }
}