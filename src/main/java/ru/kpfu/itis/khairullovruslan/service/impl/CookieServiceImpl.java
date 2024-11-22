package ru.kpfu.itis.khairullovruslan.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.service.CookieService;
import ru.kpfu.itis.khairullovruslan.service.UserService;

public class CookieServiceImpl implements CookieService {
    private final static CookieServiceImpl INSTANCE = new CookieServiceImpl();
    private final UserService userService;

    private CookieServiceImpl() {
        userService = UserServiceImpl.getInstance();
    }

    public static CookieServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public UserDTO findUser(HttpServletRequest req) {
        Cookie[] cookie = req.getCookies();

        if (cookie != null) {
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("user")) {
                    return userService.findByLogin(cookie1.getValue());
                }
            }
        }
        return null;
    }
}
