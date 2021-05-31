package dev.jongho.membertest;

import dev.jongho.membertest.member.Member;
import dev.jongho.membertest.member.MemberRepository;
import dev.jongho.membertest.member.MemberService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class MemberServiceTest {

    @Mock MemberRepository memberRepository;

    @Test
    void create_member() {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        Member member = new Member(1L, "jongho", 10);

        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(member));

        // When
        Member findMember = memberService.getById(5L);

        // Then
        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getName(), member.getName());
        assertEquals(findMember.getAge(), member.getAge());
    }

    @Test
    void delete_member_under_14() {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        Member member = new Member(1L, "jongho", 10);

        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(member));

        // When
        Member findMember = memberService.getById(5L);

        // Then
        assertThrows(IllegalAccessException.class, () ->
            memberService.deleteAccount(findMember)
        );
    }

    @Test
    void delete_member_below_14() throws IllegalAccessException {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        Member member = new Member(1L, "jongho", 15);

        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(member));

        // When
        Member findMember = memberService.getById(5L);

        // Then
        boolean isSuccess = memberService.deleteAccount(findMember);
        assertTrue(isSuccess);
    }
}