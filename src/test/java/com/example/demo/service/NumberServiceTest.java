package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
public class NumberServiceTest {


    @Test
    public void test01() {
        log.error("~~~~~~~~~~~~~~~~~~test01");
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void checkNumber(int input, String expected) {
        Assertions.assertEquals(expected, "" + input);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, "1")
//                Arguments.of(2, "two"),
//                Arguments.of(3, "three"),
//                Arguments.of(Integer.MAX_VALUE, "huge number")
        );
    }
}
