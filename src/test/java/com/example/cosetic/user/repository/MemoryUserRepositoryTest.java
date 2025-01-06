package com.example.cosetic.user.repository;

import com.example.cosetic.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.util.*;

public class MemoryUserRepositoryTest {

    UserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("spring");

        repository.save(user);

        User result = repository.findById(user.getId()).get();

        assert result.getName().equals("spring");
    }

    @Test
    public void findByName(){
        User user1 = new User();
        user1.setName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        repository.save(user2);

        Optional<User> result = repository.findByName("spring1");

        assert result.isPresent();
        assert result.get().getName().equals("spring1");
    }

    @Test
    public void findAll(){
        User user1 = new User();
        user1.setName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        repository.save(user2);

        List<User> result = repository.findAll();

        assert result.size() == 2;
        assert result.get(0).getName().equals("spring1");
        assert result.get(1).getName().equals("spring2");
    }


}
