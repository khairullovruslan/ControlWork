package ru.kpfu.itis.khairullovruslan.dao.impl;

import ru.kpfu.itis.khairullovruslan.dao.UserDAO;
import ru.kpfu.itis.khairullovruslan.entity.User;
import ru.kpfu.itis.khairullovruslan.mapper.UserMapper;
import ru.kpfu.itis.khairullovruslan.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final UserDAOImpl INSTANCE = new UserDAOImpl();


    //language=sql
    private static final String SAVE_SQL = """
                insert into users(login, password, age)
                values (?, ?, ?);
            """;

    //language=sql
    private static final String FIND_BY_LOGIN_SQL = """
            select * from users where login = ?
            """;

    private UserDAOImpl() {
    }

    public static UserDAOImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(User user) {
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User findByLogin(String login) {
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_SQL)) {
            preparedStatement.setString(1, login);
            return UserMapper.convertResultSetToUser(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
