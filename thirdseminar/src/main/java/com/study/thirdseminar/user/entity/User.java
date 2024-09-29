package com.study.thirdseminar.user.entity;

import com.study.thirdseminar.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
//@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Timestamp userSignupTime;

    public void changeValue(UserDto userDto) {
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }
}
