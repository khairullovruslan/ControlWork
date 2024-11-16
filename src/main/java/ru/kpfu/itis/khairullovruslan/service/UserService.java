package ru.kpfu.itis.khairullovruslan.service;

import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.dto.UserRegistrationDTO;

import java.sql.SQLException;

public interface UserService {
    void save(UserRegistrationDTO userRegistrationDTO);

    UserDTO findByLogin(String value) ;
}
