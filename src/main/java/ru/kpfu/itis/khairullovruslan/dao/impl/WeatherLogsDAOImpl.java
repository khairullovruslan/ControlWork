package ru.kpfu.itis.khairullovruslan.dao.impl;


import ru.kpfu.itis.khairullovruslan.dao.WeatherLogsDAO;
import ru.kpfu.itis.khairullovruslan.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeatherLogsDAOImpl implements WeatherLogsDAO {
    private static final WeatherLogsDAOImpl INSTANCE = new WeatherLogsDAOImpl();

    private static final String SAVE_SQL = """
                insert into weather_logs(userLogin, cityName) VALUES (?, ?)
            """;


    private WeatherLogsDAOImpl() {

    }

    public static WeatherLogsDAOImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public void save(String userLogin, String cityName) {
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, cityName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
