package top.soft.bookonline.service;

import top.soft.bookonline.entity.User;

public interface UserService {
    /**
     * 用户登录功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    User signIn(String account, String password);

    /**
     * 用户注册
     * @param user 用户对象
     * @return 注册成功返回true，否则返回false
     */

    User signUp(String account, String password);
}
