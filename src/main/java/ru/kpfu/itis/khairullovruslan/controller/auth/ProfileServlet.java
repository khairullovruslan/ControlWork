package ru.kpfu.itis.khairullovruslan.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.service.UserService;
import ru.kpfu.itis.khairullovruslan.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        boolean find = false;

        if (cookie != null) {
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("user")) {
                    UserDTO userDTO = userService.findByLogin(cookie1.getValue());
                    req.setAttribute("login", userDTO.getLogin());
                    req.setAttribute("age", userDTO.getAge());
                    find = true;
                    break;
                }
            }
        }

        if (find) {
            req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

}
