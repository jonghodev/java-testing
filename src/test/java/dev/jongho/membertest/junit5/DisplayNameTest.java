package dev.jongho.membertest.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DisplayNameTest {

    @Test
    void display_name_not_exists() {
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("테스트 제목")
    void display_name_exists() {
        assertEquals(1, 1);
    }
}