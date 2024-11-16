package ru.kpfu.itis.khairullovruslan.dao.impl;

import ru.kpfu.itis.khairullovruslan.dao.LoginLogsDAO;
import ru.kpfu.itis.khairullovruslan.util.DatabaseConnectionUtil;

import java.sql.*;
import java.time.LocalDateTime;

public class LoginLogsDAOImpl implements LoginLogsDAO {
    private final static LoginLogsDAOImpl INSTANCE = new LoginLogsDAOImpl();


    private static final String SAVE_SQL = """
                insert into login_logs(login, isSuccess, time)
                values (?, ?, ?);
            """;

    private LoginLogsDAOImpl(){
    }
    public static LoginLogsDAOImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(boolean isSuccess, String login) {
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, login);
            preparedStatement.setBoolean(2, isSuccess);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
