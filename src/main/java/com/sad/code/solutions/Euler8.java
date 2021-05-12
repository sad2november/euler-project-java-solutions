package com.sad.code.solutions;

import com.sad.code.util.LogTimer;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
 * What is the value of this product?
 */
@Component
public class Euler8 {

    @LogTimer
    @Step("Looking for greatest product of 13 nums")
    public long solution(@NonNull final String value) {
        Allure.addAttachment("Value in problem", value);

        val nums = new ArrayList<Integer>();
        Stream.of(value.split("")).forEach(x -> {
            try {
                nums.add(Integer.parseInt(x));
            } catch (Exception ignored) {
            }
        });

        var result = Long.MIN_VALUE;

        for (int i = 0; i < nums.size() - 13; i++) {
            if (nums.get(i) != 0) {
                var tempProduct = 1L;
                for (int j = i; j < i + 13; j++) {
                    if (nums.get(j) == 0) {
                        break;
                    } else {
                        tempProduct *= nums.get(j);
                        if (tempProduct > result) {
                            result = tempProduct;
                        }
                    }
                }
            }
        }

        return result == Long.MIN_VALUE ? 0 : result;
    }
}