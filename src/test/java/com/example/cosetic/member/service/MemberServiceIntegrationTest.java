package com.example.cosetic.member.service;

import com.example.cosetic.member.domain.Member;
import com.example.cosetic.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;



    @Test
    public void testJoinMember() throws Exception {
        // Given
        Member member = new Member(); // 변수 이름 수정
        member.setName("hello");

        // When
        Long saveId = memberService.join(member);

        // Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void testDuplicateMemberException() throws Exception {
        // Given
        Member member1 = new Member(); // 변수 이름 수정
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // When
        memberService.join(member1);

        // 중복 데이터 테스트
        IllegalStateException e = assertThrows(
                IllegalStateException.class,
                () -> memberService.join(member2) // 중복 데이터 삽입
        );

        // Then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}