package com.sad.code;

import com.sad.code.solutions.Euler9;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler9
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler9.class})
public class Euler9Test {

    @Autowired
    Euler9 euler9;

    @Test
    @Link("https://projecteuler.net/problem=9")
    @Description(
            "Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n" +
                    " * a^2 + b^2 = c^2\n" +
                    " * For example, 32 + 42 = 9 + 16 = 25 = 52.\n" +
                    " * There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n" +
                    " * Find the product abc."
    )
    public void test() {
        assertEquals(31875000, euler9.bruteForceSolution(1000));
    }
}