package ru.kpfu.itis.khairullovruslan.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.kpfu.itis.khairullovruslan.dto.UserDTO;

public interface CookieService {

    UserDTO findUser(HttpServletRequest req);
}
