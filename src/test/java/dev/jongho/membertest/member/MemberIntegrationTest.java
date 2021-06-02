package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
class MemberIntegrationTest {

    @Autowired
    MemberService memberService;

    @Test
    void delete_member() throws Exception {
        Member createMember = new Member(1L, "jongho", 15);
        memberService.create(createMember);
        memberService.deleteAccount(1L);
    }

    @Test
    void delete_not_exists_member() {
        assertThrows(RuntimeException.class, () -> memberService.deleteAccount(1L));
    }
}
