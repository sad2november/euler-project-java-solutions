package com.sad.code;

import com.sad.code.solutions.Euler11;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler11
 */
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler11.class})
public class Euler11Test {

    @Autowired
    Euler11 euler11;

    @Test
    @SneakyThrows
    @Link("https://projecteuler.net/problem=11")
    @Description("In the 20×20 grid below, four numbers along a diagonal line have been marked in red.\n" +
            "The product of these numbers is 26 × 63 × 78 × 14 = 1788696.\n" +
            "What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?")
    public void test() {
        val problemString = new String(Files.readAllBytes(new ClassPathResource("Euler11").getFile().toPath()));
        assertEquals(70600674, euler11.solution(problemString));
    }
}