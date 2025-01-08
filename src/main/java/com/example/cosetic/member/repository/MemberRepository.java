package com.example.cosetic.member.repository;

import com.example.cosetic.member.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member Member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
