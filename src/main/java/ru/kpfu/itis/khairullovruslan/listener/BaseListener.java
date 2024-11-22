package ru.kpfu.itis.khairullovruslan.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.kpfu.itis.khairullovruslan.service.AuthService;
import ru.kpfu.itis.khairullovruslan.service.OpenWeatherMapService;
import ru.kpfu.itis.khairullovruslan.service.impl.WeatherLogsServiceImpl;

@WebListener
public class BaseListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();


        servletContext.setAttribute("authService", AuthService.getInstance());
        servletContext.setAttribute("openWeatherMapService", OpenWeatherMapService.getInstance());
        servletContext.setAttribute("weatherLogsService", WeatherLogsServiceImpl.getInstance());


    }
}
