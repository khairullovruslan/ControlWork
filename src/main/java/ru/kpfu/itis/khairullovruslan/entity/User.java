package ru.kpfu.itis.khairullovruslan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;
    private int age;
}
