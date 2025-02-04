package com.example.cosetic.member.service;

import com.example.cosetic.member.domain.Member;
import com.example.cosetic.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(@Qualifier("springDataJpaMemberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    ///  회원 가입
    public Long join(Member Member) {
        // 같은 이름이 있는 중복 회원 x
        validateDuplicateMember(Member);

        memberRepository.save(Member);
        return Member.getId();
    }

    public void validateDuplicateMember(Member Member){
        Optional<Member> result = memberRepository.findByName(Member.getName());
        result.ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /// 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long MemberId){
        return memberRepository.findById(MemberId);
    }

}
