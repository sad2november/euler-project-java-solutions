package com.sad.code;

import com.sad.code.solutions.Euler3;
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
 * @see Euler3
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler3.class})
public class Euler3Test {

    @Autowired
    Euler3 euler3;

    @ParameterizedTest
    @CsvSource({
            "600851475143, 6857",
            "903245778320, 73"
    })
    @Link("https://projecteuler.net/problem=3")
    @Description(
            "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
                    " What is the largest prime factor of the number 600851475143 ?"
    )
    public void test(final long from1UnderThisValue, final long expectingResult) {
        assertAll(
                () -> assertEquals(expectingResult, euler3.sieveSolution(from1UnderThisValue)),
                () -> assertEquals(expectingResult, euler3.bruteForceSolution(from1UnderThisValue))
        );
    }
}