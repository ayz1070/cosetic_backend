package com.example.cosetic.user.service;

import com.example.cosetic.user.domain.User;
import com.example.cosetic.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ///  회원 가입
    public String join(User user) {
        // 같은 이름이 있는 중복 회원 x
        validateDuplicateUser(user);

        userRepository.save(user);
        return user.getId();
    }

    public void validateDuplicateUser(User user){
        Optional<User> result = userRepository.findByName(user.getName());
        result.ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /// 전체 회원 조회
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(String userId){
        return userRepository.findById(userId);
    }

}
