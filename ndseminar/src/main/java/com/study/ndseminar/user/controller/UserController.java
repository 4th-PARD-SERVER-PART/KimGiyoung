package com.study.ndseminar.user.controller;

import com.study.ndseminar.user.dto.UserDto;
import com.study.ndseminar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "확인됬음요~";
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId) {
        return userService.findById(studentId);
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{studentId}")
    public String updateById(@PathVariable Long studentId, @RequestBody UserDto userDto) {
        userService.update(studentId, userDto);
        return "수정되었음~";
    }

    @DeleteMapping("/{studentId}")
    public String deleteById(@PathVariable Long studentId) {
        userService.delete(studentId);
        return "삭제되었음~";
    }
}
