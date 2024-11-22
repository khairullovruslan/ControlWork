package ru.kpfu.itis.khairullovruslan.service.impl;

import ru.kpfu.itis.khairullovruslan.dao.WeatherLogsDAO;
import ru.kpfu.itis.khairullovruslan.dao.impl.WeatherLogsDAOImpl;
import ru.kpfu.itis.khairullovruslan.service.WeatherLogsService;

public class WeatherLogsServiceImpl implements WeatherLogsService {
    private final static WeatherLogsServiceImpl INSTANCE = new WeatherLogsServiceImpl();
    private final WeatherLogsDAO weatherLogsDAO;

    private WeatherLogsServiceImpl() {

        weatherLogsDAO = WeatherLogsDAOImpl.getInstance();
    }

    public static WeatherLogsServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(String userLogin, String cityName) {
        weatherLogsDAO.save(userLogin, cityName);
    }
}
