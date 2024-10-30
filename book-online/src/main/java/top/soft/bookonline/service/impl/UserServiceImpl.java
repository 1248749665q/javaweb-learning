package top.soft.bookonline.service.impl;



import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/10/26 14:13
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    private JdbcTemplate jdbcTemplate;
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }

    @Override
    public User signUp(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        userDao.insertUser(user);
        return user;
    }

}