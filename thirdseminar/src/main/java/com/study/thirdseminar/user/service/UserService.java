package com.study.thirdseminar.user.service;

import com.study.thirdseminar.user.dto.UserDto;
import com.study.thirdseminar.user.entity.User;
import com.study.thirdseminar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        userRepository.save(user);
    }

    public UserDto read(Long userId){
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public List<UserDto> readAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user ->
                UserDto.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()).toList();
        return userDtos;
    }

    public void update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).get();
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
        user.changeValue(userDto);

        userRepository.save(user);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public Long getUserNum(String email){
        User user = userRepository.findByEmail(email);
        System.out.println("서비스 단임" + user.getUserId() + "\n");
        return user.getUserId();
    }
}
