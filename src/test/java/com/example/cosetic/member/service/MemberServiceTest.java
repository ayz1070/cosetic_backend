package com.example.cosetic.member.service;

import com.example.cosetic.member.domain.Member;
import com.example.cosetic.member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService MemberService;
    MemoryMemberRepository MemberRepository;

    @BeforeEach
    public void beforeEach(){
        MemberRepository = new MemoryMemberRepository();
        MemberService = new MemberService(MemberRepository);
    }

    @AfterEach
    public void afterEach(){
        MemberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member Member = new Member();
        Member.setName("hello");

        // when
        Long saveId = MemberService.join(Member);

        // then
        Member findMember = MemberService.findOne(saveId).get();
        assert Member.getName().equals(findMember.getName());
    }

    @Test
    void joinException() {
        // given
        Member Member1 = new Member();
        Member1.setName("spring");

        Member Member2 = new Member();
        Member2.setName("spring");

        // when
        MemberService.join(Member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> MemberService.join(Member2));

        // assertThat(e.getMessage()).equals("이미 존재하는 회원입니다.");
    }

    @Test
    void validateDuplicateMember() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}