package ru.kpfu.itis.khairullovruslan.service.impl;

import ru.kpfu.itis.khairullovruslan.dao.LoginLogsDAO;
import ru.kpfu.itis.khairullovruslan.dao.impl.LoginLogsDAOImpl;
import ru.kpfu.itis.khairullovruslan.service.LoginLogsService;

public class LoginLogsServiceImpl implements LoginLogsService {
    private final static LoginLogsServiceImpl INSTANCE = new LoginLogsServiceImpl();
    private final LoginLogsDAO loginLogsDAO;

    private LoginLogsServiceImpl(){
        loginLogsDAO = LoginLogsDAOImpl.getInstance();
    }
    public static LoginLogsServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(boolean isSuccess,  String login){
        loginLogsDAO.save(isSuccess, login);
    }
}
