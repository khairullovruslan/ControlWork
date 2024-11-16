package ru.kpfu.itis.khairullovruslan.service.impl;

import ru.kpfu.itis.khairullovruslan.dao.impl.UserDAOImpl;
import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.dto.UserRegistrationDTO;
import ru.kpfu.itis.khairullovruslan.entity.User;
import ru.kpfu.itis.khairullovruslan.mapper.UserMapper;
import ru.kpfu.itis.khairullovruslan.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl  implements UserService {
    private final static UserServiceImpl INSTANCE = new UserServiceImpl();
    private final UserDAOImpl userDAO;

    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }
    private UserServiceImpl(){
        userDAO = UserDAOImpl.getInstance();

    }
    @Override
    public void save(UserRegistrationDTO userRegistrationDTO) {
        userDAO.save(UserMapper.userRegistrationDTOmapToUser(userRegistrationDTO));
    }

    @Override
    public UserDTO findByLogin(String value)  {
        return UserMapper.convertUserToDTO(userDAO.findByLogin(value));
    }


}
