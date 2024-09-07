package by.alst.project.jdbc.service;

import by.alst.project.jdbc.dao.UserDao;
import by.alst.project.jdbc.dto.UserDto;
import by.alst.project.jdbc.entity.User;

import java.util.List;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private UserService() {
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao = UserDao.getInstance();

    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(user -> new UserDto(user.getId(), user.getEmail(),
                user.getPassword(), user.getRegistrationDate(), user.getRoleId(), user.getGenderId())).toList();
    }

    public UserDto findById(Integer usersId) {
        User user = userDao.findById(usersId).orElse(new User());
        return new UserDto(user.getId(), user.getEmail(),
                user.getPassword(), user.getRegistrationDate(), user.getRoleId(), user.getGenderId());
    }
}
