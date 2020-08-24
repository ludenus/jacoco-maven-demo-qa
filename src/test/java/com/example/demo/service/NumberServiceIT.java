package com.example.demo.service;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
public class NumberServiceIT {

    @ParameterizedTest
    @MethodSource("testData")
    public void checkNumber(int input, String expected) {
        sleep(input);
        var actual = apiCall(input);
        Assertions.assertEquals(expected, actual);
    }

    private String apiCall(int n) {
        var url = "http://0.0.0.0:28080/api/number-to-words?n=" + n;
        return RestAssured.given()
                .when().log().all().get(url)
                .then().log().all().statusCode(200)
                .extract().body().asString();

    }

    private static Stream<Arguments> testData() {
        return Stream.of(
//                Arguments.of(1, "one"),
                Arguments.of(2, "two"),
//                Arguments.of(3, "three"),
                Arguments.of(30000, "huge number")
        );
    }

    @SneakyThrows
    private static int sleep(int msec) {
        log.info("sleeping for {} msec...", msec);
        Thread.sleep(msec);
        return msec;
    }
}
