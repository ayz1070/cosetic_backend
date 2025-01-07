package com.example.cosetic;

import com.example.cosetic.member.repository.MemberRepository;
import com.example.cosetic.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


///  의존성 주입 직접 하기

@Configuration
public class SpringConfig {

    @Autowired
    @Qualifier("springDataJpaMemberRepository") //
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(@Qualifier("springDataJpaMemberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}