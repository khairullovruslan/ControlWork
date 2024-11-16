package ru.kpfu.itis.khairullovruslan.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import jakarta.servlet.annotation.WebListener;
import ru.kpfu.itis.khairullovruslan.service.AuthService;

@WebListener
public class BaseListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();


        servletContext.setAttribute("authService", AuthService.getInstance());


    }
}
