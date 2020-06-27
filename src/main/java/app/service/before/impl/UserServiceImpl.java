package app.service.before.impl;

import app.dao.before.UserDao;
import app.entity.User;
import app.service.before.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public int register(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int cancelAccount(String id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updatePassword(String id, String password) {
        return userDao.updatePassword(id, password);
    }

    // @Override
    // public List<User> findAllUser() {
    //     return userDao.findAllUser();
    // }

    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public User checkLogin(String id, String pwd) {
        return userDao.findUserByIdAndPwd(id, pwd);
    }
}
