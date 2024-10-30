package top.soft.bookonline.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.JdbcUtil;
import top.soft.bookonline.util.Md5Util;

/**
 * @author lhy
 * @description: UserDao 实现层
 * @date 2024/10/20 16:40
 */
public class UserDaoImpl implements UserDao {
    //声名Jdbd对象
    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public int insertUser(User user) {
        //插入用户:sql
        String sql="insert into t_user(account,password,nickname,avatar) values(?,?,?,?)";
        return jdbcTemplate.update(sql,user.getAccount(), Md5Util.crypt(user.getPassword()),user.getNickname(),user.getAvatar());
    }
    @Override
    public User findUser(User user) {
        String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getAccount(), Md5Util.crypt(user.getPassword()));
    }
}
