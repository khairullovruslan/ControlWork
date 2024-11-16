package ru.kpfu.itis.khairullovruslan.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
    private String login;
    private String password;
    private int age;
}