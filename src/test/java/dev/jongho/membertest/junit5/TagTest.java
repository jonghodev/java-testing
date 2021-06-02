package dev.jongho.membertest.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagTest {

    @Test
    @Tag("slow")
    void test_slow1() {

    }

    @Test
    @Tag("slow")
    void test_slow2() {

    }

    @Test
    @Tag("fast")
    void test_fast1() {

    }

    @Test
    @Tag("fast")
    void test_fast2() {

    }
}
