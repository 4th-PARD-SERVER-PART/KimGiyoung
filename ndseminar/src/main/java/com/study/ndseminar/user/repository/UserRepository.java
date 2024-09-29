package com.study.ndseminar.user.repository;

import com.study.ndseminar.user.dto.UserDto;
import com.study.ndseminar.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<Long, User> handong = new HashMap<>();

    public void save(UserDto userDto) {
        User user = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentId(), user);
    }

    public UserDto findById(Long studentId) {
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }

    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                        .studentId(user.getStudentId())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }

    public void update(Long studentId, UserDto userDto) {
        User user = handong.get(studentId);
        user.setStudentName(userDto.getStudentName());
        user.setStudentId(userDto.getStudentId());
    }

    public void delete(Long studentId) {
        handong.remove(studentId);
    }
}


