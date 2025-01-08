package com.example.cosetic.member.repository;

import com.example.cosetic.member.domain.Member;
import com.example.cosetic.member.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("memoryMemberRepository")

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member Member) {
        Member.setId(++sequence);
        store.put(Member.getId(), Member);
        return Member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(Member -> Member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
