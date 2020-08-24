package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
public class NumberServiceIT {

    @Test
    public void test02() {
        log.error("~~~~~~~~~~~~~~~~~~test02");
    }


    @ParameterizedTest
    @MethodSource("testData2")
    public void checkNumber(int input, String expected) {
        Assertions.assertEquals(expected, "" + input);
    }

    private static Stream<Arguments> testData2() {
        return Stream.of(
                Arguments.of(1, "1")
//                Arguments.of(2, "two"),
//                Arguments.of(3, "three"),
//                Arguments.of(Integer.MAX_VALUE, "huge number")
        );
    }
}
