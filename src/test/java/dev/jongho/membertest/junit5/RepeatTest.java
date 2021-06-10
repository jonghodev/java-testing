package dev.jongho.membertest.junit5;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RepeatTest {

    @Test
    @RepeatedTest(value = 10, name = "{currentRepetition}/{totalRepetitions}")
    void repeat_test() {
    }
}
