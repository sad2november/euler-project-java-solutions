package com.sad.code;

import com.sad.code.solutions.Euler5;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler5
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler5.class})
public class Euler5Test {

    @Autowired
    Euler5 euler5;

    @ParameterizedTest
    @CsvSource({
            "20, 232792560",
            "30, 2329089562800",
            "40, 5342931457063200",
            "50, 3099044504245996706400",
            "60, 9690712164777231700912800",
            "70, 79211881234889091923261227200",
            "80, 32433859254793982911622772305630400",
            "90, 718766754945489455304472257065075294400",
            "100, 69720375229712477164533808935312303556800",
            "200, 337293588832926264639465766794841407432394382785157234228847021917234018060677390066992000"
    })
    @Link("https://projecteuler.net/problem=5")
    @Description(
            "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n" +
                    "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
    )
    public void test(final int maxNumberValue, final String expectingResult) {
        assertEquals(expectingResult, euler5.solution(maxNumberValue));
    }
}