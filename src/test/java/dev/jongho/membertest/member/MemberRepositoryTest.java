package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.domain.MemberRepository;
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
    void Should_Find_Age_After() {
        /**
         * 12살부터 15살까지의 Member 4명을 생성한다.
         */
        for (int age = 12; age <= 15; age++) {
            Member createMember = new Member("jongho", age);
            memberRepository.save(createMember);
        }

        List<Member> members = memberRepository.findByAgeAfter(14);

        /**
         * 14살보다 많은 Member는 한 명 밖에 없을 것이다.
         */
        assertEquals(1, members.size());
    }
}
