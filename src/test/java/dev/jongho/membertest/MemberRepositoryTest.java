package dev.jongho.membertest;

import dev.jongho.membertest.member.Member;
import dev.jongho.membertest.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void find_age_after() {
        for (int age = 12; age <= 15; age++) {
            Member createMember = new Member("jongho", age);
            memberRepository.save(createMember);
        }

        List<Member> members = memberRepository.findByAgeAfter(14);
        assertEquals(members.size(), 1);
    }
}
