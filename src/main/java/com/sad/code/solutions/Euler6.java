package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is .
 * <p>
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 */
@Component
public class Euler6 {

    @LogTimer
    @Attachment
    @Step("Find the difference between the sum of the squares from 1 to {value} and the square of the sum")
    public String bruteForceSolution(final long value) {
        var sumOfSquares = BigInteger.ZERO;
        var squareOfSum = BigInteger.ZERO;

        for (long i = 1L; i <= value; i++) {
            sumOfSquares = sumOfSquares.add(new BigInteger("" + i).pow(2));
            squareOfSum = squareOfSum.add(new BigInteger("" + i));
        }

        return squareOfSum.pow(2).subtract(sumOfSquares).toString();
    }

    /**
     * (∑(i=1,n,i)^2 − ∑(i=1,n,(i^2)) = -1/12 * (3n^2 + 2n) * (1 - n^2), n∈N
     *
     * @param value max value
     * @return difference between the sum of the squares
     */
    @LogTimer
    @Attachment
    @Step("Find the difference between the sum of the squares from 1 to {value} and the square of the sum")
    public String smartSolution(final long value) {
        val value_ = new BigInteger("" + value);

        return (value_.pow(2).multiply(new BigInteger("3")).add(value_.multiply(new BigInteger("2"))))
                .multiply(BigInteger.ONE.subtract(value_.pow(2)))
                .multiply(new BigInteger("-1"))
                .divide(new BigInteger("12")).toString();
    }

}