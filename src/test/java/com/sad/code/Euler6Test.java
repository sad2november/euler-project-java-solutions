package com.sad.code;

import com.sad.code.solutions.Euler6;
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
 * @see Euler6
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler6.class})
public class Euler6Test {

    @Autowired
    Euler6 euler6;

    @ParameterizedTest
    @CsvSource({
            "100, 25164150",
            "200, 401323300",
            "500, 15645770750",
            "1000, 250166416500",
            "100000, 25000166664166650000",
            "10000000, 2500000166666641666665000000",
            "100000000, 25000000166666664166666650000000"
    })
    @Link("https://projecteuler.net/problem=6")
    @Description(
            "Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .\n" +
                    "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
    )
    public void test(final long maxNumberValue, final String expectingResult) {
        assertAll(
                () -> assertEquals(expectingResult, euler6.bruteForceSolution(maxNumberValue)),
                () -> assertEquals(expectingResult, euler6.smartSolution(maxNumberValue))
        );
    }
}