package com.study.thirdseminar.user.controller;

import com.study.thirdseminar.user.dto.UserDto;
import com.study.thirdseminar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto readById(@PathVariable Long userId) {
        return userService.read(userId);
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @GetMapping("/userNum")
    public ResponseEntity<Long> readByEmail(@RequestParam String email) {
        Long responseValue = userService.getUserNum(email);
        System.out.println(responseValue);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }
}
