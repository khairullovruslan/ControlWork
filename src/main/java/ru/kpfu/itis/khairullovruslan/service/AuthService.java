package ru.kpfu.itis.khairullovruslan.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.khairullovruslan.dao.UserDAO;
import ru.kpfu.itis.khairullovruslan.dao.impl.UserDAOImpl;
import ru.kpfu.itis.khairullovruslan.dto.UserRegistrationDTO;
import ru.kpfu.itis.khairullovruslan.entity.User;
import ru.kpfu.itis.khairullovruslan.service.impl.LoginLogsServiceImpl;
import ru.kpfu.itis.khairullovruslan.service.impl.UserServiceImpl;
import ru.kpfu.itis.khairullovruslan.util.PasswordUtil;

import java.io.IOException;


public class AuthService {

    private final static AuthService INSTANCE = new AuthService();
    private final UserService userService;
    private final UserDAO userDAO;
    private final LoginLogsService loginLogsService;

    private AuthService() {
        userService = UserServiceImpl.getInstance();
        userDAO = UserDAOImpl.getInstance();
        loginLogsService = LoginLogsServiceImpl.getInstance();
    }

    public static AuthService getInstance() {
        return INSTANCE;
    }

    public void registration(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.save(UserRegistrationDTO.builder()
                .age(Integer.parseInt(req.getParameter("age")))
                .login(req.getParameter("login"))
                .password(PasswordUtil.encrypt(req.getParameter("password")))
                .build());
        resp.sendRedirect(req.getContextPath() + "/login");
    }


    public void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserRegistrationDTO userRegistrationDTO = UserRegistrationDTO.builder()
                .login(req.getParameter("login"))
                .password(PasswordUtil.encrypt(req.getParameter("password")))
                .build();
        User user = userDAO.findByLogin(userRegistrationDTO.getLogin());
        boolean success = false;
        if (user.getPassword().equals(userRegistrationDTO.getPassword())) {
            Cookie cookie = new Cookie("user", user.getLogin());
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
            success = true;
            resp.sendRedirect(req.getContextPath() + "/profile");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        loginLogsService.save(success, user.getLogin());


    }
}
