package dev.jongho.membertest.member;

import dev.jongho.membertest.member.domain.Member;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class MemberApiTest {

    @Autowired
    protected MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void member_create() throws Exception {
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

    public ResultActions requestSignup(Member member) throws Exception {
        return this.mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(member)))
                .andDo(print());
    }
}
