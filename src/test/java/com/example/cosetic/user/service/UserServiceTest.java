package com.example.cosetic.user.service;

import com.example.cosetic.user.domain.User;
import com.example.cosetic.user.repository.MemoryUserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    public void beforeEach(){
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @AfterEach
    public void afterEach(){
        userRepository.clearStore();
    }

    @Test
    void join() {
        // given
        User user = new User();
        user.setName("hello");

        // when
        String saveId = userService.join(user);

        // then
        User findUser = userService.findOne(saveId).get();
        assert user.getName().equals(findUser.getName());
    }

    @Test
    void joinException() {
        // given
        User user1 = new User();
        user1.setName("spring");

        User user2 = new User();
        user2.setName("spring");

        // when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));

        // assertThat(e.getMessage()).equals("이미 존재하는 회원입니다.");
    }

    @Test
    void validateDuplicateUser() {
    }

    @Test
    void findUsers() {
    }

    @Test
    void findOne() {
    }
}