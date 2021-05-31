package dev.jongho.membertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceTest {

    int a = 1;

    @Test
    void test_1() {
        System.out.println(a++);
        System.out.println(this);
    }

    @Test
    void test_2() {
        System.out.println(a);
        System.out.println(this);
    }
}
