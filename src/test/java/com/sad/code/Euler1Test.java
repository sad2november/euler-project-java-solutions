package com.sad.code;

import com.sad.code.solutions.Euler1;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Link;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler1
 */
@EnableAutoConfiguration
@ComponentScan("com.sad.code")
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class})
public class Euler1Test {

    @Autowired
    Euler1 euler1;

    @ParameterizedTest
    @CsvSource({
            "100, 2318",
            "1000, 233168",
            "10000, 23331668",
            "100000, 2333316668",
            "1000000, 233333166668",
            "10000000, 23333331666668",
            "100000000, 2333333316666668",
            //overflow "1000000000, 2333333331666666_6_8_8"
    })
    @Link("https://projecteuler.net/problem=1")
    public void test(final long from1ToThisValue, final long expectingResult) {
        assertAll(
                () -> assertEquals(expectingResult, euler1.bruteForceSolution(from1ToThisValue)),
                () -> assertEquals(expectingResult, euler1.smartSolution(from1ToThisValue))
        );
    }
}