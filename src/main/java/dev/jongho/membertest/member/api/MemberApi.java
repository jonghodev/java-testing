package dev.jongho.membertest.member.api;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member) {
        return memberService.create(member);
    }
}
