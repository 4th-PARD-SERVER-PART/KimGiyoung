package com.study.ndseminar.user.service;

import com.study.ndseminar.user.dto.UserDto;
import com.study.ndseminar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        userRepository.save(userDto);
    }

    public UserDto findById(Long studentId) {
        return userRepository.findById(studentId);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public void update(Long studentId, UserDto userDto) {
        userRepository.update(studentId, userDto);
    }

    public void delete(Long studentId) {
        userRepository.delete(studentId);
    }
}
