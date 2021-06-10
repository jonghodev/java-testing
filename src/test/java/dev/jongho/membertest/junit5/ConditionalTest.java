package dev.jongho.membertest.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class ConditionalTest {

    @Test
    void assuming_that_1() {
        assumingThat(1 + 1 == 2, () ->
            assertEquals(1, 1)
        );
    }

    @Test
    void assuming_that_2() {
        assumingThat(1 + 1 == 3, () ->
                assertEquals(1, 2)
        );
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void enabled_on_os() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void enabled_on_jre() {
    }
}
