package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.domain.MemberRepository;
import dev.jongho.membertest.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock MemberRepository memberRepository;

    @Test
    void Should_Member_Created() {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        System.out.println(memberRepository.getClass());
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
    void Should_ThrowException_When_DeleteAccount_NotExistsMember() {
        // Given
        MemberService memberService = new MemberService(memberRepository);

        // Then
        assertThrows(RuntimeException.class, () ->
                memberService.deleteAccount(1L)
        );
    }

    @Test
    void Should_ThrowException_When_DeleteAccount_AgeLessThan14() {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        Member member = new Member(1L, "jongho", 10);

        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(member));

        assertThrows(IllegalAccessException.class, () ->
            memberService.deleteAccount(1L)
        );
    }

    @Test
    void Should_Success_When_DeleteAccount_AgeMoreThan14() throws IllegalAccessException {
        // Given
        MemberService memberService = new MemberService(memberRepository);
        Member member = new Member(1L, "jongho", 15);

        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(member));

        // When
        boolean isSuccess = memberService.deleteAccount(1L);

        // Then
        assertTrue(isSuccess);
    }
}