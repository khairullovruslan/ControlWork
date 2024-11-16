package ru.kpfu.itis.khairullovruslan.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import ru.kpfu.itis.khairullovruslan.service.AuthService;

import java.io.IOException;

@WebServlet("/login")
@Slf4j
public class LoginServlet extends HttpServlet {


    private AuthService authService;

    @Override
    public void init()  {
        authService = (AuthService) this.getServletContext().getAttribute("authService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("checking user data");
        authService.signIn(req, resp);
    }
}
