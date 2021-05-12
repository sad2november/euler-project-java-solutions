package com.sad.code;

import com.sad.code.solutions.Euler10;
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
 * @see Euler10
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler10.class})
public class Euler10Test {

    @Autowired
    Euler10 euler10;

    @ParameterizedTest
    @CsvSource({
            "2000000, 142913828922",
            "20000000, 12272577818052"
    })
    @Link("https://projecteuler.net/problem=10")
    @Description(
            "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n" +
                    "Find the sum of all the primes below two million."
    )
    public void test(final long from1UnderThisValue, final long expectingResult) {
        assertEquals(expectingResult, euler10.sieveSolution(from1UnderThisValue));
    }
}