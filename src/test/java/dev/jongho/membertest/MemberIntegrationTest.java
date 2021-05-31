package dev.jongho.membertest;

import dev.jongho.membertest.member.Member;
import dev.jongho.membertest.member.MemberRepository;
import dev.jongho.membertest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class MemberIntegrationTest {

    @Autowired
    MemberService memberService;

    @Test
    void delete_member() throws Exception {
        Member createMember = new Member(1L, "jongho", 15);
        memberService.create(createMember);

        Member member = memberService.getById(1L);
        assertEquals(member.getId(), 1L);
        assertEquals(member.getName(), "jongho");
        assertEquals(member.getAge(), 15);

        memberService.deleteAccount(member);
    }
}
