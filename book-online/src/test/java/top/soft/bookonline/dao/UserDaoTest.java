package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao=new UserDaoImpl();
        User user= User.builder()
                .account("lhy")
                .nickname("lhy").password("123456").address("南京").avatar("https://x0.ifengimg.com/ucms/2022_29/CA0B7C6C1D44CED11B5B654D91723D77BFAA32D4_size759_w3069_h3781.jpg").build();
        userDao.insertUser(user);
    }
}