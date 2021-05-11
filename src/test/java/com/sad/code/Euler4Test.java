package com.sad.code;

import com.sad.code.solutions.Euler4;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler4
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler4.class})
public class Euler4Test {

    @Autowired
    Euler4 euler4;

    @ParameterizedTest
    @CsvSource({
            "999, 906609",
            "9999, 99000099"
    })
    @Link("https://projecteuler.net/problem=4")
    @Description(
            "A palindromic number reads the same both ways.\n" +
                    "The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n" +
                    "Find the largest palindrome made from the product of two 3-digit numbers."
    )
    public void test(final long from1UnderThisValue, final long expectingResult) {
        assertAll(
                () -> assertEquals(expectingResult, euler4.bruteForceSolution(from1UnderThisValue))
        );
    }
}