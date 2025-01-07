package com.example.cosetic.member.repository;

import com.example.cosetic.member.domain.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("springDataJpaMemberRepository")
@Primary
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {
    Optional<Member> findByName(String name);
}