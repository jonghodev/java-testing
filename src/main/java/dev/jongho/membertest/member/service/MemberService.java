package dev.jongho.membertest.member.service;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Transactional
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public boolean deleteAccount(Long id) throws IllegalAccessException {
        Member member = this.getById(id);

        if (member.getAge() < 14) {
            throw new IllegalAccessException("회원이 14살 보다 어릴경우 부모님 동의를 받아야 합니다.");
        }

        memberRepository.delete(member);
        return true;
    }
}
