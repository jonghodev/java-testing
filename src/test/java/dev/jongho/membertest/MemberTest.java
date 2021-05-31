package dev.jongho.membertest;

import dev.jongho.membertest.member.Member;
import dev.jongho.membertest.member.MemberRepository;
import dev.jongho.membertest.member.MemberService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MemberTest {

    @Test
    void create_member() {
        Member member = new Member(1L, "A", 1);
        assertEquals(member.getId(), 1L);
        assertEquals(member.getName(), "A");
        assertEquals(member.getAge(), 1);
    }
}