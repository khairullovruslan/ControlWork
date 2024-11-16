package ru.kpfu.itis.khairullovruslan.mapper;

import ru.kpfu.itis.khairullovruslan.dto.UserDTO;
import ru.kpfu.itis.khairullovruslan.dto.UserRegistrationDTO;
import ru.kpfu.itis.khairullovruslan.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

  public static User userRegistrationDTOmapToUser(UserRegistrationDTO userRegistrationDTO){
      return User
              .builder()
              .age(userRegistrationDTO.getAge())
              .login(userRegistrationDTO.getLogin())
              .password(userRegistrationDTO.getPassword())
              .build();
  }

  public static User convertResultSetToUser(ResultSet resultSet) throws SQLException {
      while (resultSet.next()) {
          return User
                  .builder()
                  .password(resultSet.getString("password"))
                  .login(resultSet.getString("login"))
                  .age(resultSet.getInt("age"))
                  .build();

      }
      return null;
  }

    public static UserDTO convertUserToDTO(User user) {
        return UserDTO
                .builder()
                .age(user.getAge())
                .login(user.getLogin())
                .build();
    }
}
