package ru.kpfu.itis.khairullovruslan.dao;

import ru.kpfu.itis.khairullovruslan.entity.User;

public interface UserDAO {
    void save(User user);

    User findByLogin(String login);
}
