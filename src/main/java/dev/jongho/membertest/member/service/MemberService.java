package dev.jongho.membertest.member.service;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("No member matching"));
    }

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public boolean deleteAccount(Long id) throws IllegalAccessException {
        Member member = this.getById(id);

        if (member.getAge() < 14) {
            throw new IllegalAccessException("14살 보다 어릴경우 부모님 동의를 받아야 합니다.");
        }

        return true;
    }
}
