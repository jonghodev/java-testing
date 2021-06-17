package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import dev.jongho.membertest.member.domain.MemberRepository;
import dev.jongho.membertest.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class MemberApiTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void Should_Member_Created() throws Exception {
        // Given
        Member member = new Member(1L, "jongho", 15);

        // When
        final ResultActions resultActions = requestSignup(member);

        // Then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(member.getId()))
                .andExpect(jsonPath("name").value(member.getName()))
                .andExpect(jsonPath("age").value(member.getAge()));
    }

    @Test
    void Should_Delete_Member() throws Exception {
        // Given
        Member member = new Member(1L, "jongho", 15);
        memberService.save(member);

        // When
        final ResultActions resultActions = requestDeleteMember(1L);

        // Then
        resultActions
                .andExpect(status().isOk());
    }

    public ResultActions requestSignup(Member member) throws Exception {
        return this.mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(member)))
                .andDo(print());
    }

    public ResultActions requestDeleteMember(Long id) throws Exception {
        return this.mockMvc.perform(delete("/members/" + id))
                .andDo(print());
    }
}
