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
    @EnabledOnOs(OS.MAC)
    void assuming_that() {
        assumingThat(1 == 1, () ->
            assertEquals(1, 1)
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
