package com.example.cosetic.member.repository;

import com.example.cosetic.member.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member Member = new Member();
        Member.setName("spring");

        repository.save(Member);

        Member result = repository.findById(Member.getId()).get();

        assert result.getName().equals("spring");
    }

    @Test
    public void findByName(){
        Member Member1 = new Member();
        Member1.setName("spring1");
        repository.save(Member1);

        Member Member2 = new Member();
        Member2.setName("spring2");
        repository.save(Member2);

        Optional<Member> result = repository.findByName("spring1");

        assert result.isPresent();
        assert result.get().getName().equals("spring1");
    }

    @Test
    public void findAll(){
        Member Member1 = new Member();
        Member1.setName("spring1");
        repository.save(Member1);

        Member Member2 = new Member();
        Member2.setName("spring2");
        repository.save(Member2);

        List<Member> result = repository.findAll();

        assert result.size() == 2;
        assert result.get(0).getName().equals("spring1");
        assert result.get(1).getName().equals("spring2");
    }


}
