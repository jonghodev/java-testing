package dev.jongho.membertest.member;

import org.springframework.stereotype.Service;

@Service
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

    public boolean deleteAccount(Member member) throws IllegalAccessException {
        if (member.getAge() < 14) {
            throw new IllegalAccessException("14살 보다 어릴경우 부모님 동의를 받아야 합니다.");
        }

        return true;
    }
}
