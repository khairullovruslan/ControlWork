package ru.kpfu.itis.khairullovruslan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDTO {
    private String login;
    private int age;
}
