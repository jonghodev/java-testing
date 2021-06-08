package dev.jongho.membertest.member.api;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PostMapping("")
    public Member saveMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMember(@PathVariable Long id) throws Exception {
        return memberService.deleteAccount(id);
    }
}
