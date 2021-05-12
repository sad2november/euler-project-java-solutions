package com.sad.code;

import com.sad.code.solutions.Euler8;
import com.sad.code.solutions.Euler9;
import com.sad.code.util.LogTimerAspect;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @see Euler8
 */
@Slf4j
@EnableAutoConfiguration
@SpringBootTest(classes = {EmptyService.class, LogTimerAspect.class, Euler8.class})
public class Euler8Test {

    @Autowired
    Euler8 euler8;

    @Test
    @SneakyThrows
    @Link("https://projecteuler.net/problem=9")
    @Description(
            "The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.\n" +
                    "Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.\n" +
                    "What is the value of this product?"
    )
    public void test() {
        val problemString = new String(Files.readAllBytes(new ClassPathResource("Euler8").getFile().toPath()));
        assertEquals(23514624000L, euler8.solution(problemString));
    }
}