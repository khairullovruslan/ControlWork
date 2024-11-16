package ru.kpfu.itis.khairullovruslan.controller.auth;


import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.khairullovruslan.dto.UserRegistrationDTO;
import ru.kpfu.itis.khairullovruslan.service.AuthService;

import java.io.IOException;


@WebServlet("/registration")
@Slf4j
public class RegistrationServlet extends HttpServlet {
    private AuthService authService;
    @Override
    public void init()  {
        authService = (AuthService) this.getServletContext().getAttribute("authService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("registration precessing");
        authService.registration(req, resp);
    }
}
