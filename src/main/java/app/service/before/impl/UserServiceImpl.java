package app.service.before.impl;

import app.dao.before.UserDao;
import app.entity.User;

import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:35
 */
public class UserServiceImpl implements UserDao {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int deleteUserById(String id) {
        return 0;
    }

    @Override
    public int updateUserById(User user) {
        return 0;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public User findUser(User user) {
        return null;
    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public User findUserByIdAndPwd(String id, String pwd) {
        return null;
    }
}
