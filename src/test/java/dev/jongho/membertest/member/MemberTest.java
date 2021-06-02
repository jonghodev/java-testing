package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MemberTest {

    @Test
    void create_member() {
        Member member = new Member(1L, "jongho", 15);
        assertEquals(member.getId(), 1L);
        assertEquals(member.getName(), "jongho");
        assertEquals(member.getAge(), 15);
    }

    @Test
    void member_below_1() {
        assertThrows(RuntimeException.class, () -> new Member(1L, "jongho", 0));
    }
}