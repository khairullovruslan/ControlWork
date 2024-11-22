package ru.kpfu.itis.khairullovruslan.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.service.CookieService;
import ru.kpfu.itis.khairullovruslan.service.impl.CookieServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/profile", "/"})
public class ProfileServlet extends HttpServlet {
    private CookieService cookieService;

    @Override
    public void init() throws ServletException {
        super.init();
        cookieService = CookieServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO userDTO = cookieService.findUser(req);
        if (userDTO != null) {
            req.setAttribute("login", userDTO.getLogin());
            req.setAttribute("age", userDTO.getAge());
            req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

}
